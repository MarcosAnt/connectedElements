package connectedElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import entity.Element;

public class Network {
	
	private List<Element> elements;
	
	public Network (int qtde) throws NumberFormatException {
		
		if (qtde <= 0) {
			throw new NumberFormatException("Necessário um número inteiro positivo.");
		}
		List<Element> elements = new ArrayList<Element>();
		
		for (int i = 0; i < 8; i++) {
			Element element = new Element(i+1, new ArrayList<Integer>());
			
			elements.add(element);
		}
		
		setElements(elements);
	}
	
	// conecta dois elementos
	public void connect(int elementId, int idToConnect) {
		
		List<Element> elements = getElements();
		
		for (int i = 0; i < elements.size(); i++) {
			
			if (Objects.equals(elements.get(i).getId(), elementId)) {
				elements.get(i).getConnectedElements().add(idToConnect);
			}
		}
		
		setElements(elements);		
	}
	
	// verifica se dois elementos estão conectados
	public Boolean query(int elementId1, int elementId2) {
		
		Boolean isDirectedConnected = verifyDirectConnection(elementId1, elementId2);
		
		// conectado indiretamente
		if(!isDirectedConnected) {
			Boolean indirectConnected = false;
			List<Element> elements = getElements();
			Element element1 = new Element();
			
			for (Element eltId1 : elements) {
				
				if (Objects.equals(eltId1.getId(), elementId1)) {
					element1 = eltId1;
					break;
				}
			}
			
			for (Element eltId2 : elements) {
				if(element1.getConnectedElements().contains(eltId2.getId())) {
					
					List<Integer> connectedElements = new ArrayList<>();
					connectedElements = eltId2.getConnectedElements();
					
					if(connectedElements.contains(elementId2)) {
						indirectConnected = true;
						break;
					}
				}
			}
			
			return indirectConnected;
		} else {
			return true;
		}
		
	}
	
	private Boolean verifyDirectConnection(int elementId1, int elementId2) {
		
		List<Element> elements = getElements();
		
		for (Element element : elements) {
			
			if (Objects.equals(element.getId(), elementId1)) {
				
				List<Integer> connections = element.getConnectedElements();
				
				// conectado diretamente
				if (connections.contains(elementId2)) {
					return true;
				}
			}
		}
		
		return false;
	}

	
	// Getters e Setters
	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

}
