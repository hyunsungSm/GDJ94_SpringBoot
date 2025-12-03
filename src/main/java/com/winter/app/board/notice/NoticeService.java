package com.winter.app.board.notice;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.notice}")
	private String uploagPath;
	
    @Override
	public Long count(Pager pager) throws Exception {
		return null;
	}

	public List<BoardDTO> list(Pager pager) throws Exception {
    	// 1. totalCount 구하기
    	Long totalCount = noticeDAO.count(pager);
    	pager.pageing(totalCount);
    	
    	
    	return noticeDAO.list(pager);
    }	
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.detail(boardDTO);
	}
	
	public int add(BoardDTO boardDTO, MultipartFile [] attach)throws Exception {
		
		int result = noticeDAO.add(boardDTO);
		
		// 1. 파일을 HDD에 저장 
		// 	  1) 어디에 저장?
		// 	  2) 어떤 이름으로 저장?
		File file = new File(uploagPath);
		for(MultipartFile f: attach) {
			if (f==null || f.isEmpty()) {
				continue;
			}
			String filename = fileManager.fileSave(file, f);
			
			// 4. 정보를 DB에 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(filename);
			boardFileDTO.setFileOrigin(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeDAO.fileAdd(boardFileDTO);
		}
		
		return result;
	}
	
//	@Override
//	   public int delete(BoardDTO boardDTO)throws Exception{
//	      boardDTO = noticeDAO.detail(boardDTO);
//	      //HDD에서 파일을 삭제
//	      if(boardDTO.getFileDTOs() != null) {
//	         for(BoardFileDTO boardFileDTO:boardDTO.getFileDTOs()) {
//	            File file = new File(uploagPath, boardFileDTO.getFileName());
//	            boolean flag = fileManager.fileDelete(file);
//	            
//	         }
//	      }
//	      
//	      //---------------
//	      int result = noticeDAO.fileDelete(boardDTO);
//	      return noticeDAO.delete(boardDTO);
//	   }
//	
//	public int update(BoardDTO boardDTO)throws Exception{
//		return noticeDAO.update(boardDTO);
//	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BoardFileDTO fileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.fileDetail(boardFileDTO);
	}
	
}
