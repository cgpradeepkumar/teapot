package in.library.services.util;

import java.util.ArrayList;
import java.util.List;

import in.library.services.mongodb.SequenceGeneratorService;
import in.library.services.mongodb.documents.Item;
import in.library.services.util.model.Data;

public class XlsToDocumentMapper {

	public static List<Item> map(List<Data> dataList, SequenceGeneratorService sequenceGeneratorService) {
		List<Item> items = new ArrayList<Item>();
		for (Data data : dataList) {
			Item item = new Item();
			item.setId(sequenceGeneratorService.generateSequence(Item.SEQUENCE_NAME));
			item.setTitle(data.getTitle());
			item.setAuthor(data.getAuthor());
			item.setPublisher(data.getPublisher());
			item.setPrice(data.getPrice());
			item.setLanguage(data.getLanguage());
			items.add(item);
		}
		return items;
	}
}
