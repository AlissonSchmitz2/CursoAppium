package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.DragDropPage;
import br.com.cursoAppium.page.MenuPage;

public class DragDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();

	private String[] estadoInicial = new String[] { "Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,",
			"e arraste para", "qualquer local desejado." };
	private String[] estadoIntermediario = new String[] { "� uma lista", "Drag em Drop!", "Fa�a um clique longo,",
			"e arraste para", "Esta", "qualquer local desejado." };
	private String[] estadoFinal = new String[] { "Fa�a um clique longo,","� uma lista", "Drag em Drop!",
			"e arraste para", "Esta", "qualquer local desejado." };

	@Test
	public void deveEfetuarDragDrop() {
		// acessar menu
		menu.acessarDragDrop();

		// verificar estado inicial
		Assert.assertArrayEquals(estadoInicial, page.obterLista());

		// arrastar "Esta" para "e arraste para"
		page.arrastar("Esta", "e arraste para");

		// verificar estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		// arrastar "Fa�a um clique longo," para "� uma lista"
		page.arrastar("Fa�a um clique longo,", "� uma lista");		
		
		// verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}

}
