package ac.moim.common.service;

import ac.moim.common.dto.SubjectDto;
import ac.moim.common.entity.Subject;
import ac.moim.common.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-30.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<SubjectDto.Response> getAllSubject() {

		List<SubjectDto.Response> subjectList = new ArrayList<SubjectDto.Response>();

		for (Subject subject : subjectRepository.findAll()) {
			subjectList.add(entityToResponseDto(subject));
		}

		return subjectList;
	}

	private SubjectDto.Response entityToResponseDto(Subject subject) {
		SubjectDto.Response response = new SubjectDto.Response();

		response.setId(subject.getId());
		response.setSeq(subject.getSeq());
		response.setParentId(subject.getParentId());
		response.setName(subject.getName());
		response.setLevel(subject.getLevel());

		return response;
	}
}