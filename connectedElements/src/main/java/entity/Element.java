/**
 * @author MarcosAnt
 * 27/04/2022
 */



package entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public class Element {
	
	private int id;
	private List<Integer> connectedElements;
	
	public Element() {}
	
	public Element(int id, List<Integer> connectedElements) {
		this.id = id;
		this.connectedElements = connectedElements;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Integer> getConnectedElements() {
		
		if(CollectionUtils.isEmpty(connectedElements))
			connectedElements = new ArrayList<Integer>();
		
		return connectedElements;
	}
	
	public void setConnectedElements(List<Integer> conectedElements) {
		this.connectedElements = conectedElements;
	}
}
