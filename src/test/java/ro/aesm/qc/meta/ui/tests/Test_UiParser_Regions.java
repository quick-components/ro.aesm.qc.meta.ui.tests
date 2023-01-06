package ro.aesm.qc.meta.ui.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import ro.aesm.qc.api.meta.component.IMetaComponentModel;
import ro.aesm.qc.meta.ui.UiModel;
import ro.aesm.qc.meta.ui.UiParser;
import ro.aesm.qc.meta.ui.model.MUi_Region;

public class Test_UiParser_Regions {

	@Test
	public void test_regions() throws Exception {

		String metaLocation = "ro/aesm/qc/meta/ui/tests/uiparser_regions.xml";
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(metaLocation);

		UiParser parser = new UiParser();
		Document doc = parser.getXmlDocument(is);
		Map<String, IMetaComponentModel> modelMap = parser.parseChildrenAsMap(doc.getDocumentElement()); // .parseResource(resourceLocation);

		UiModel model = (UiModel) modelMap.get("testRegions");
		Map<String, MUi_Region> regions = model.getRegionsMap();
		MUi_Region region;

		region = regions.get("r1");
		assertEquals("r1", region.getName(), "Region r1 has name r1");
		assertEquals("horizontal", region.getLayout(), "Region r1 has layout horizontal");
		assertEquals(2, region.getChildren().size(), "Region r1 has 2 child");
		assertEquals("i1", region.getChildren().get(0).getName(), "Region r1 first child name is i1");

		region = regions.get("r2");
		assertEquals("r2", region.getName(), "Region r2 has name r2");
		assertEquals("vertical", region.getLayout(), "Region r2 has layout vertical");
		assertEquals(1, region.getChildren().size(), "Region r2 has 1 child");
		assertEquals("r3", region.getChildren().get(0).getName(), "Region r2 child name is r3");

		region = regions.get("r3");
		assertEquals("r3", region.getName(), "Region r3 has name r3");
		assertEquals("grid", region.getLayout(), "Region r3 has layout grid");
		assertEquals(2, region.getChildren().size(), "Region r3 has 2 children");
		assertEquals("i3", region.getChildren().get(0).getName(), "Region r3 child 1 is i3");
		assertEquals("i4", region.getChildren().get(1).getName(), "Region r3 child 2 is i4");

	}
}
