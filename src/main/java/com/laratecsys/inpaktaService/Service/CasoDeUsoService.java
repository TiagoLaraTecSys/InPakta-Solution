package com.laratecsys.inpaktaService.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laratecsys.inpaktaService.Domain.Cliente;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;
import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosCasoDeUso;
import com.laratecsys.inpaktaService.Enum.DataLifeCycle;
import com.laratecsys.inpaktaService.Repositorie.CasoDeUsoRepositories;
import com.laratecsys.inpaktaService.Repositorie.DadosCasoDeUsoRepositories;
import com.laratecsys.inpaktaService.Repositorie.DadosPessoaisRepositories;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@Service
public class CasoDeUsoService {

	@Autowired
	private CasoDeUsoRepositories casoDeUsoRepositories;

	@Autowired
	private DadosPessoaisRepositories dadosPessoaisRepositories;

	@Autowired
	private DadosPessoaisService dadosPessoaisService;

	@Autowired
	private DadosCasoDeUsoRepositories dadosCasoDeUsoRepositories;

	public CasoDeUso find(Integer id) {

		UserSS userLogged = UserService.authenticated();
		Optional<CasoDeUso> caso = casoDeUsoRepositories.findById(id);

		if (!caso.get().getCliente().getId().equals(userLogged.getId())) {
			throw new AuthorizationException("Usuário não autorizado");
		}

		return caso.orElseThrow(() -> new ObjectNotFoundException("Caso de Uso não encontrado"));
	}

	@Transactional
	public CasoDeUso inserirCasoDeUso(CasoDeUso casoDeUso) {

		UserSS userLogged = UserService.authenticated();

		if (userLogged == null) {

			throw new AuthorizationException("Usuario nao esta logado");
		}
		casoDeUso.setId(null);
		Cliente logged = new Cliente(userLogged.getId(), null, null, null, null);

		casoDeUso.setCliente(logged);
		casoDeUso = casoDeUsoRepositories.save(casoDeUso);

		for (DadosCasoDeUso x : casoDeUso.getItens()) {
			// System.out.println(x.toString());
			x.setDadosPessoais(dadosPessoaisService.find(x.getDadosPessoais().getId()));
			x.setCasoDeUso(casoDeUso);
		}

		dadosCasoDeUsoRepositories.saveAll(casoDeUso.getItens());
		return casoDeUso;
	}

	public CasoDeUso atualizarCasoDeUso(CasoDeUso casoDeUso) {

		CasoDeUso newCaso = find(casoDeUso.getId());
		updateData(newCaso, casoDeUso);

		// dadosCasoDeUsoRepositories.deleteAll(newCaso.getItens());
		return newCaso;
	}

	public void updateData(CasoDeUso newObj, CasoDeUso obj) {

		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setUseConsent(obj.getUseConsent());

		if (obj.getLifecycles().size() > newObj.getLifecycles().size()) {
			for (DataLifeCycle i : obj.getLifecycles()) {
				newObj.addLifeCycle(i);
			}
		} else {
			for (DataLifeCycle i : obj.getLifecycles()) {
				newObj.getLifecycles().remove(i);
				System.out.println(newObj.getLifecycles());
				System.out.println(i.getDescricao());
				
			}
		}

		casoDeUsoRepositories.save(newObj);
		// Para excluir dados pessoais se itens que vieram no objeto for menor que o que
		// estiver salvo
		if (obj.getItens().size() < newObj.getItens().size() || obj.getItens() == null) {

			Set<DadosCasoDeUso> pert = new HashSet<>();
			pert = newObj.getItens();
			for (DadosCasoDeUso x : obj.getItens()) {
				pert.removeIf(n -> n.getDadosPessoais().getId() == x.getDadosPessoais().getId());
			}
			for (DadosCasoDeUso y : pert) {
				y.setDadosPessoais(dadosPessoaisService.find(y.getDadosPessoais().getId()));
				y.setCasoDeUso(newObj);
				dadosCasoDeUsoRepositories.delete(y);
			}

		} else {
			for (DadosCasoDeUso x : obj.getItens()) {
				// System.out.println(x.toString());
				x.setDadosPessoais(dadosPessoaisService.find(x.getDadosPessoais().getId()));
				x.setCasoDeUso(obj);
			}

			dadosCasoDeUsoRepositories.saveAll(obj.getItens());
		}

	}

	public void deletarCasoDeUso(Integer id) {

		casoDeUsoRepositories.deleteById(id);
	}

	public List<CasoDeUso> listarCasosDeUso() {

		UserSS userLogged = UserService.authenticated();

		if (userLogged == null) {
			throw new AuthorizationException("Usuario nao esta logado");
		}

		List<CasoDeUso> returned = casoDeUsoRepositories.findAllByClienteId(userLogged.getId());

		return returned;

	}

	public Page<CasoDeUso> findAllPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		UserSS userLogged = UserService.authenticated();

		return casoDeUsoRepositories.findAllByClienteId(userLogged.getId(), pageRequest);
	}

}
