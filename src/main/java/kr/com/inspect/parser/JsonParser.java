package kr.com.inspect.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.com.inspect.dto.EojeolList;
import kr.com.inspect.dto.Metadata;
import kr.com.inspect.dto.Speaker;
import kr.com.inspect.dto.Utterance;

public class JsonParser {
	
	public JSONObject getJSONObject(String fullPath) {
		JSONParser parser = new JSONParser();
	    Object obj = null;
		try {
			obj = parser.parse(new FileReader(fullPath));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ParseException e) {
			//e.printStackTrace();
		}
	    return (JSONObject) obj;
	}
	
	public Map getData(JSONObject obj) {
		Map maps = new HashMap();
		
		Map map = new HashMap();
		
		Metadata metadata = new Metadata();
		map = (Map) obj.get("metadata");
		metadata.setCreator(map.get("creator").toString());
		metadata.setAnnotation_level(map.get("annotation_level").toString());
		metadata.setYear(map.get("year").toString());
		metadata.setSampling(map.get("sampling").toString());
		metadata.setTitle(map.get("title").toString());
		metadata.setCategory(map.get("category").toString());
		metadata.setDistributor(map.get("distributor").toString());
		map = (Map) obj.get("setting");
		metadata.setRelation(map.get("relation").toString());
		System.out.println(metadata);
		maps.put("metadata", metadata);
		
		List<Speaker> speakerList = new ArrayList<>();
		map = (Map) obj.get("speaker");
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
		    String key = keys.next();
		    Map element = (Map) map.get(key);
		    Speaker speaker = new Speaker();
		    speaker.setNo(Integer.parseInt(element.get("no").toString()));
		    speaker.setShortcut(Integer.parseInt(element.get("shortcut").toString()));
		    speaker.setOccupation(element.get("occupation").toString());
		    speaker.setSex(element.get("sex").toString());
		    speaker.setName(element.get("name").toString());
		    speaker.setAge(Integer.parseInt(element.get("age").toString()));
		    speakerList.add(speaker);
		}
		maps.put("speaker", speakerList);
		
		List<Utterance> utteranceList = new ArrayList<>();
		map = (Map) obj.get("utterance");
		keys = map.keySet().iterator();
		while (keys.hasNext()) {
		    String key = keys.next();
		    Map element = (Map) map.get(key);
		    Utterance utterance = new Utterance();
		    utterance.setNote(element.get("note").toString());
		    utterance.setStandard_form(element.get("standard_form").toString());
		    utterance.setForm(element.get("form").toString());
		    utterance.setStart(Double.parseDouble(element.get("start").toString()));
		    utterance.setEnd(Double.parseDouble(element.get("end").toString()));
		    utteranceList.add(utterance);
		}
		maps.put("speaker", speakerList);
		
		
		EojeolList eojeolList = new EojeolList();
		map = (Map) map.get("eojeolList");
		return maps;
	}
}
