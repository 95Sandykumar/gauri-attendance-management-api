

package com.gaurisharma.attendance;

import com.gaurisharma.attendance.app.gradelevels.models.dto.GradeLevelDTO;
import com.gaurisharma.attendance.app.gradelevels.models.entities.GradeLevel;
import com.gaurisharma.attendance.app.guardians.models.dto.GuardianDTO;
import com.gaurisharma.attendance.app.guardians.models.entities.Guardian;
import com.gaurisharma.attendance.app.rfid_credentials.models.dto.RFIDCredentialDTO;
import com.gaurisharma.attendance.app.rfid_credentials.models.entities.RFIDCredential;
import com.gaurisharma.attendance.app.sections.models.dto.SectionStudentsDTO;
import com.gaurisharma.attendance.app.sections.models.entities.Section;
import com.gaurisharma.attendance.app.strands.models.dto.StrandDTO;
import com.gaurisharma.attendance.app.strands.models.entities.Strand;
import com.gaurisharma.attendance.app.students.enums.Sex;
import com.gaurisharma.attendance.app.students.models.dto.StudentDTO;
import com.gaurisharma.attendance.app.students.models.entities.Student;
import com.gaurisharma.attendance.app.teachers.models.dto.TeacherDTO;
import com.gaurisharma.attendance.app.teachers.models.entities.Teacher;
import com.gaurisharma.attendance.app.users.models.dto.UserDTO;
import com.gaurisharma.attendance.app.users.models.entities.User;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for testing the DTOs and Entities if they are correctly implemented.
 */
class DTOAndEntitiesTest {

	private final Strand strand = new Strand(
		1,
		"STEM"
	);

	private final GradeLevel gradeLevel = new GradeLevel(
		1,
		"Grade 11",
		strand
	);

	private final Teacher teacher = new Teacher(
		1,
		"Juan",
		"Dela Cruz",
		"Male",
		new User()
	);

	private final Section section = new Section(
		1,
		teacher,
		"Room 403",
		strand,
		gradeLevel,
		"Section A",
		new ArrayList<>()
	);

	private final Student student = new Student(
		1L,
		"Rahul",
		"K",
		"Sharma",
		null,
		gradeLevel,
		Sex.MALE,
		section,
		new Guardian(),
		"12 MG Road, Bangalore",
		LocalDate.parse("2004-07-07")
	);

	private final RFIDCredential rfidCredential = new RFIDCredential(
		1,
		student,
		"hashed_lrn",
		"salt"
	);

	private final Guardian guardian = new Guardian(
		1,
		"Juan Dela Cruz",
		"09123456789",
		student
	);

	private final User user = new User(
		1,
		"gauri",
		"hashed_password",
		"gauri.sharma@example.com",
		"admin",
		true,
		false,
		false,
		false,
		Instant.now(),
		Instant.now()
	);

	@Test
	void testRFIDCredential() {
		// Entities Test
		assert rfidCredential.getId() == 1;
		assert rfidCredential.getLrn().equals(student);
		assert rfidCredential.getHashedLrn().equals("hashed_lrn");
		assert rfidCredential.getSalt().equals("salt");
		System.out.println("Entity Test is successful");

		// DTO Test
		RFIDCredentialDTO rfidCredentialDTO = rfidCredential.toDTO();
		assert rfidCredentialDTO.getId() == 1;
		assert rfidCredentialDTO.getHashedLrn().equals("hashed_lrn");
		assert rfidCredentialDTO.getSalt().equals("salt");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testGuardian() {
		// Entities Test
		assert guardian.getId() == 1;
		assert guardian.getFullName().equals("Juan Dela Cruz");
		assert guardian.getContactNumber().equals("09123456789");
		System.out.println("Entity Test is successful");

		// DTO Test
		GuardianDTO guardianDTO = guardian.toDTO();
		assert guardianDTO.getId() == 1;
		assert guardianDTO.getFullName().equals("Juan Dela Cruz");
		assert guardianDTO.getContactNumber().equals("09123456789");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testUser() {
		// Entities Test
		assert user.getId() == 1;
		assert user.getUsername().equals("gauri");
		assert user.getPassword().equals("hashed_password");
		assert user.getEmail().equals("gauri.sharma@example.com");
		assert user.getRole().equals("admin");
		System.out.println("Entity Test is successful");

		// DTO Test
		UserDTO userDTO = user.toDTO();
		assert userDTO.getId() == 1;
		assert userDTO.getUsername().equals("gauri");
		assert userDTO.getEmail().equals("gauri.sharma@example.com");
		assert userDTO.getRole().equals("admin");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testStudent() {
		// Entities Test
		assert student.getId() == 1;
		assert student.getFirstName().equals("Rahul");
		assert student.getMiddleInitial().equals("K");
		assert student.getLastName().equals("Sharma");
		assert student.getPrefix() == null;
		assert student.getGradeLevel().equals(gradeLevel);
		assert student.getSex().equals("Male");
		assert student.getSection().equals(section);
		assert student.getAddress().equals("12 MG Road, Bangalore");
		assert student.getBirthdate().equals(LocalDate.parse("2004-07-07"));
		System.out.println("Entity Test is successful");

		// DTO Test
		StudentDTO studentDTO = student.toDTO();
		assert studentDTO.getId() == 1;
		assert studentDTO.getFirstName().equals("Rahul");
		assert studentDTO.getMiddleInitial().equals("K");
		assert studentDTO.getLastName().equals("Sharma");
		assert studentDTO.getPrefix() == null;
		assert studentDTO.getGradeLevel().equals(gradeLevel.toDTO());
		assert studentDTO.getSex().equals("Male");
		assert studentDTO.getSection().equals(section.toDTO());
		assert studentDTO.getAddress().equals("12 MG Road, Bangalore");
		assert studentDTO.getBirthdate().equals(LocalDate.parse("2004-07-07"));
		System.out.println("DTO Test is successful");
	}

	@Test
	void testSection() {
		// Entities Test
		assert section.getId() == 1;
		assert section.getTeacher().equals(teacher);
		assert section.getRoom().equals("Room 403");
		assert section.getStrand().equals(strand);
		assert section.getGradeLevel().equals(gradeLevel);
		assert section.getSectionName().equals("Section A");
		System.out.println(section.getStudents().size());
		assert section.getStudents().size() == 1;
		System.out.println("Entity Test is successful");

		// DTO Test
		SectionStudentsDTO sectionDTO = new SectionStudentsDTO(
			section.toDTO(),
			List.of(student.toDTO())
		);

		assert sectionDTO.getId() == 1;
		assert sectionDTO.getTeacher().equals(teacher.toDTO());
		assert sectionDTO.getRoom().equals("Room 403");
		assert sectionDTO.getStrand().equals(strand.toDTO());
		assert sectionDTO.getGradeLevel().equals(gradeLevel.toDTO());
		assert sectionDTO.getSectionName().equals("Section A");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testStrand() {
		// Entities Test
		assert strand.getId() == 1;
		assert strand.getName().equals("STEM");
		System.out.println("Entity Test is successful");

		// DTO Test
		StrandDTO strandDTO = strand.toDTO();
		assert strandDTO.getId() == 1;
		assert strandDTO.getName().equals("STEM");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testGradeLevel() {
		// Entities Test
		assert gradeLevel.getId() == 1;
		assert gradeLevel.getName().equals("Grade 11");
		assert gradeLevel.getStrand().equals(strand);
		System.out.println("Entity Test is successful");

		// DTO Test
		GradeLevelDTO gradeLevelDTO = gradeLevel.toDTO();
		assert gradeLevelDTO.getId() == 1;
		assert gradeLevelDTO.getName().equals("Grade 11");
		assert gradeLevelDTO.getStrand().equals(strand.toDTO());
		System.out.println("DTO Test is successful");
	}

	@Test
	void testTeacher() {
		// Entities Test
		assert teacher.getId() == 1;
		assert teacher.getFirstName().equals("Juan");
		assert teacher.getLastName().equals("Dela Cruz");
		assert teacher.getSex().equals("Male");
		System.out.println("Entity Test is successful");

		// DTO Test
		TeacherDTO teacherDTO = teacher.toDTO();
		assert teacherDTO.getId() == 1;
		assert teacherDTO.getFirstName().equals("Juan");
		assert teacherDTO.getLastName().equals("Dela Cruz");
		assert teacherDTO.getSex().equals("Male");
		System.out.println("DTO Test is successful");
	}

	@Test
	void testStudentSectionDTO() {
		// DTO Test
		SectionStudentsDTO sectionStudentsDTO = new SectionStudentsDTO(
			1,
			teacher.toDTO(),
			"Room 403",
			strand.toDTO(),
			gradeLevel.toDTO(),
			"Section A",
			List.of(student.toDTO())
		);

		assert sectionStudentsDTO.getId() == 1;
		assert sectionStudentsDTO.getTeacher().equals(teacher.toDTO());
		assert sectionStudentsDTO.getRoom().equals("Room 403");
		assert sectionStudentsDTO.getStrand().equals(strand.toDTO());
		assert sectionStudentsDTO.getGradeLevel().equals(gradeLevel.toDTO());
		assert sectionStudentsDTO.getSectionName().equals("Section A");
		System.out.println("DTO Test is successful");

		// To Entity
		Section section = sectionStudentsDTO.toEntity();

		assert section.getId() == 1;
		assert section.getTeacher().getId().equals(teacher.getId());
		assert section.getTeacher().getFirstName().equals("Juan");
		assert section.getTeacher().getLastName().equals("Dela Cruz");
		assert section.getTeacher().getSex().equals("Male");
		assert section.getRoom().equals("Room 403");
		assert section.getStrand().getId().equals(strand.getId());
		assert section.getStrand().getName().equals("STEM");
		assert section.getGradeLevel().getId().equals(gradeLevel.getId());
		assert section.getGradeLevel().getName().equals("Grade 11");
		assert section.getSectionName().equals("Section A");
		assert section.getStudents().size() == 1;
		System.out.println("Entity Test is successful");
	}
}