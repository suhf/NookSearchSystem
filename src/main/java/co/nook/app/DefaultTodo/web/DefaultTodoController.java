package co.nook.app.DefaultTodo.web;

import co.nook.app.DefaultTodo.service.DefaultTodoService;
import co.nook.app.DefaultTodo.vo.DefaultTodoVo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;

@Controller
public class DefaultTodoController{

	private DefaultTodoService defaultTodoService;

	public DefaultTodoController(DefaultTodoService defaultTodoService){
		this.defaultTodoService = defaultTodoService;
	}

	@RequestMapping("/adminDataInsertPage.do")
	public String adminDataInsertPage(Model model){
		ArrayList<DefaultTodoVo> list = defaultTodoService.selectAll();
		System.out.println("Size : " +list.size());
		model.addAttribute("list", list);

		return "admin/admin_data";
	}

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/defaultDataInsert.do", method = RequestMethod.POST)
	public String defaultDataInsert(HttpServletRequest request, MultipartFile file, Model model){
		if(!verifyDefaultTodoFile(file))
			return "invalid";

		String path = request.getServletContext().getRealPath("\\WEB-INF\\uploaded\\");
		System.out.println(path);
		String saveName = file.getOriginalFilename();
		File saveFile = new File(path, saveName);
		boolean isSaved = false;
		try{
			file.transferTo(saveFile);
			isSaved = true;
		}catch( IOException e){
			e.printStackTrace();
		}
		try{
			if(isSaved){
				//TODO : 파일이 제대로된 데이터인지 검증하는 단계 필요
				InputStreamReader iReader =new InputStreamReader(file.getInputStream(), "UTF-8");
				//CSVReader reader = new CSVReader(new FileReader( path+"\\"+saveName));
				CSVReader reader = new CSVReader(iReader);

				defaultTodoService.truncate();
				String [] nextLine;
				int line = 1;
				while((nextLine = reader.readNext()) != null){

					if(line > 3){
						DefaultTodoVo vo = csvLineToVo(nextLine);
						defaultTodoService.insert(vo);
					}
					++line;
				}
				iReader.close();
			}
		}catch(CsvValidationException | IOException e){
				e.printStackTrace();
		}

		ArrayList<DefaultTodoVo> list = defaultTodoService.selectAll();
		model.addAttribute("list", list);

		return String.valueOf(isSaved);
	}
	private DefaultTodoVo csvLineToVo(String[] line){
		DefaultTodoVo vo = new DefaultTodoVo();
		vo.setdTodoNo(Integer.valueOf(line[0]));
		vo.setdIsAlways(line[1].toUpperCase().trim());
		vo.setdContent(line[2].trim());
		vo.setdDay(line[3].trim());
		vo.setdMinCount( line[4].isEmpty()? null: Integer.valueOf(line[4]) );
		vo.setdMaxCount( line[5].isEmpty()? null : Integer.valueOf(line[5]) );
		vo.setdNpcName(line[6].trim());
		vo.setdIsEvent(line[7].toUpperCase().trim());
		vo.setdEventStartDate(line[8].isEmpty()? null : line[8].trim());
		vo.setdEventStartHour(line[9].isEmpty()? null: Integer.valueOf(line[9]));
		vo.setdEventEndDate(line[10].isEmpty()? null: line[10].trim());
		vo.setdEventEndHour(line[11].isEmpty()? null: Integer.valueOf(line[11]));
		vo.setdSpecialFunction(line[12].isEmpty()? null: line[12].trim());
		vo.setdSpecialData1(line[13].isEmpty()? null: line[13].trim());
		vo.setdSpecialData2(line[14].isEmpty()? null: line[14].trim());
		vo.setdSpecialData3(line[15].isEmpty()? null: line[15].trim());
		vo.setdSpecialData4(line[16].isEmpty()? null: line[16].trim());

		return vo;
	}

	private boolean verifyDefaultTodoFile(MultipartFile file){

		try{
			InputStreamReader iReader =new InputStreamReader(file.getInputStream(), "UTF-8");
			CSVReader reader = new CSVReader(iReader);
			String[] lines;

			int line = 1;
				while((lines = reader.readNext()) != null){
					if( line > 3){
						if((! lines[0].isEmpty() && NumberUtils.isCreatable(lines[0])) == false){
							System.out.println(1);
							System.out.println(lines[0]);
							reader.close();
							return false;
						}
						if((! lines[1].isEmpty() && isStringBoolean(lines[1])) == false){
							System.out.println(2);
							System.out.println(lines[1]);
							reader.close();
							return false;
						}
						if((! lines[2].isEmpty()) == false){
							System.out.println(3);
							System.out.println(lines[2]);
							reader.close();
							return false;
						}
						if((! lines[3].isEmpty() && isStringDay(lines[3])) == false){
							System.out.println(4);
							System.out.println(lines[3]);
							reader.close();
							return false;
						}
						if(! lines[4].isEmpty()){
							if(NumberUtils.isCreatable(lines[4]) == false){
								System.out.println(5);
								System.out.println(lines[4]);
								reader.close();
								return false;
							}
						}
						if(! lines[5].isEmpty()){
							if(NumberUtils.isCreatable(lines[5]) == false){
								System.out.println(6);
								System.out.println(lines[5]);
								reader.close();
								return false;
							}
						}
						if((! lines[7].isEmpty() && isStringBoolean(lines[7])) == false){
							System.out.println(7);
							System.out.println(lines[7]);
							reader.close();
							return false;
						}

						if(! lines[8].isEmpty()){
							if(! isValidDate(lines[8])){
								System.out.println(8);
								System.out.println(lines[8]);
								reader.close();
								return false;
							}
						}

						if(! lines[9].isEmpty()){
							if(! NumberUtils.isCreatable(lines[9])){
								System.out.println(9);
								System.out.println(lines[9]);
								reader.close();
								return false;
							}
						}

						if(! lines[10].isEmpty()){
							if(! isValidDate(lines[10])){
								System.out.println(10);
								System.out.println(lines[10]);
								reader.close();
								return false;
							}
						}
						if(! lines[11].isEmpty()){
							if(! NumberUtils.isCreatable(lines[11])){
								System.out.println(11);
								System.out.println(lines[11]);
								reader.close();
								return false;
							}
						}
					}
					++line;
				}

			reader.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	private boolean isStringBoolean(String str){
		String temp = str.toLowerCase();

		if( temp.equals("true") || temp.equals("false")){
			return true;
		}

		return false;
	}
	final String[] days = {"월","화","수","목","금","토","일"};
	private boolean isStringDay(String str){
		String[] strings = str.split(",");
		for( int i = 0 ; i < strings.length; ++i){
			strings[i] = strings[i].trim();
			if ( !StringUtils.containsAny(strings[i], days) )
				return false;
		}
		return true;
	}

	private boolean isValidDate(String str){


		str = str.replace(" ","" );
		String[] strings = str.split(",");
		if(strings.length != 2)
			return false;


		String[] temp = strings[0].split("/");
		if( temp.length != 2)
			return false;

		if(!NumberUtils.isCreatable(temp[0]) || !NumberUtils.isCreatable(temp[1]))
			return false;
		int left = Integer.parseInt(temp[0]);
		int right = Integer.parseInt(temp[1]);
		if(left > 99 || left < 1  || right > 99 || right < 1)
			return false;

		temp = strings[1].split("/");
		if( temp.length != 2)
			return false;

		if(!NumberUtils.isCreatable(temp[0]) || !NumberUtils.isCreatable(temp[1]))
			return false;
		left = Integer.parseInt(temp[0]);
		right = Integer.parseInt(temp[1]);
		if(left > 99 || left < 1  || right > 99 || right < 1)
			return false;

		return true;

	}
}
