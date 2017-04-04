package ac.moim.study.entity;

import ac.moim.common.entity.BaseEntity;
import ac.moim.common.entity.City;
import ac.moim.common.entity.State;
import ac.moim.common.entity.Subject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"studyMemberList", "commentList", "resourceList"})
@Entity
@Table(name = "study")
public class Study extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Column(name = "title")
	private String title;

	@Column(name = "intro")
	private String intro;
	
	@Column(name = "input_user")
	private String inputUser;

	@ManyToOne
	@JoinColumn(name = "city_code")
	private City city;

	@Column(name = "member_count")
	private int memberCount;

	@Column(name = "member_limit")
	private int memberLimit;

	@Column(name = "delete_check")
	private boolean deleteCheck = false;

	@Column(name = "hit")
	private int hit = 0;

	@OneToMany(mappedBy = "id.study",fetch = FetchType.LAZY)
	private List<StudyMember> studyMemberList;

	@OneToMany(mappedBy = "studyId", fetch = FetchType.LAZY)
	private List<Comment> commentList;

	@OneToMany(mappedBy = "studyId", fetch = FetchType.LAZY)
	private List<Resource> resourceList;
}
