package ac.moim.dashboard.service;

import ac.moim.dashboard.entity.StudyArticle;
import ac.moim.dashboard.repository.StudyDashboardRepository;
import ac.moim.study.entity.Study;
import ac.moim.study.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thdghgns on 2017. 4. 5..
 */
@Service
public class StudyDashboardServiceImpl implements StudyDashboardService {

	@Autowired
	StudyDashboardRepository studyDashboardRepository;

	@Autowired
	StudyRepository studyRepository;

	@Override
	public List<StudyArticle> findAllByStudy(Integer studyId, Pageable pageable) {
		Study study = studyRepository.findById(studyId);
		List<StudyArticle> studyDashboards = studyDashboardRepository.findByStudy(study, pageable);

		return studyDashboards;
	}

	@Override
	public StudyArticle findOne(Long articleId) {
		StudyArticle studyArticle = studyDashboardRepository.findOne(articleId);

		return studyArticle;
	}
}
