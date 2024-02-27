package com.himedia.hicinema.movie.theater;

import com.himedia.hicinema.movie.loc.LocationRepository;
import com.himedia.hicinema.upload.FileRepository;
import com.himedia.hicinema.upload.FileUploadService;
import com.himedia.hicinema.upload.UploadFiles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TheaterService {
	private final TheaterRepository theaterRepository;
	private final FileUploadService fileUploadService;
	private final FileRepository fileRepository;
	private final LocationRepository locationRepository;


	public void saveTheater(TheaterForm tf, List<MultipartFile> fileList) throws Exception {
		List<String> fileIdList = new ArrayList<>();
		//이미지 등록
		for(int i=0;i<fileList.size();i++){

			UploadFiles files = new UploadFiles();

			String imgName =  fileUploadService.saveItemImg(files, fileList.get(i));
			UploadFiles file = fileRepository.findByImgName(imgName);
			fileIdList.add(String.valueOf(file.getId()));
		}

		Theater theater = tf.createTheater();
		theater.setFile_id(String.join(", ", fileIdList));
		theater.setLocation(locationRepository.findById(tf.getLoc_id()).get());
		System.out.println(theater);
		theaterRepository.save(theater);
	}
}
