package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.payload.request.GradeAddRequest;
import com.registerapp.registerServerAPI.payload.request.GradeUpdateRequest;
import com.registerapp.registerServerAPI.payload.response.GetGradeByClassAndSubjectResponse;
import com.registerapp.registerServerAPI.payload.response.GetGradeByStudentIdResponse;
import com.registerapp.registerServerAPI.payload.response.GradeAddResponse;
import com.registerapp.registerServerAPI.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GradeService {

    private GradeRepository gradeRepository;
    private RegisterRepository registerRepository;
    private StudentRepository studentRepository;
    private GradeTypeRepository gradeTypeRepository;
    private GradeValueRepository gradeValueRepository;

    public List<GetGradeByClassAndSubjectResponse> getGradesByClassAndSubject(Long class_id, Long subject_id) {
        Set<Grade> grades = gradeRepository.findAllByClassAndSubject(class_id, subject_id);


        return grades.stream()
                .map(grd -> mapToGetGradeByClassAndSubjectResponse(grd))
                .collect(Collectors.toList());
    }

    public List<GetGradeByStudentIdResponse> findAllByStudentId(Long student_id, LocalDateTime date) {
        List<Grade> grades = gradeRepository.findAllByStudentId(student_id, date);


        return grades.stream()
                .map(grd -> mapToGetGradeByStudentIdResponse(grd))
                .collect(Collectors.toList());
    }

    private GetGradeByStudentIdResponse mapToGetGradeByStudentIdResponse(Grade grd) {
        return GetGradeByStudentIdResponse.builder()
                .value_text(grd.getGrade_value_id().getText())
                .type_text(grd.getGrade_type_id().getText())
                .subject(grd.getRegister_id().getSubject_id().getName())
                .build();
    }

    private GetGradeByClassAndSubjectResponse mapToGetGradeByClassAndSubjectResponse(Grade grd) {
        return GetGradeByClassAndSubjectResponse.builder()
                .grade_id(grd.getGrade_id())
                .value(grd.getGrade_value_id().getValue())
                .type_value(grd.getGrade_type_id().getValue())
                .type_text(grd.getGrade_type_id().getText())
                .text(grd.getGrade_value_id().getText())
                .comment(grd.getComment())
                .date(grd.getDate())
                .student_id(grd.getStudent_id().getStudent_id())
                .weight(grd.getWeight())
                .build();
    }

    public GradeAddResponse addGrade(GradeAddRequest gradeAddRequest) {
        Student student = studentRepository.findById(gradeAddRequest.getStudent_id()).orElseThrow(() -> new IllegalStateException("Student o id " + gradeAddRequest.getStudent_id() + " nie istnieje."));
        Register register = registerRepository.findByClassAndTeacherAndSubject(gradeAddRequest.getClass_id(), gradeAddRequest.getTeacher_id(), gradeAddRequest.getSubject_id());
        GradeType gradeType = gradeTypeRepository.findById(gradeAddRequest.getGrade_type_id()).orElseThrow(() -> new IllegalStateException("Typ oceny o id " + gradeAddRequest.getGrade_type_id() + " nie istnieje."));
        GradeValue gradeValue = gradeValueRepository.findById(gradeAddRequest.getGrade_value_id()).orElseThrow(() -> new IllegalStateException("Wartość oceny o id " + gradeAddRequest.getGrade_value_id() + " nie istnieje."));

        Grade grade = gradeRepository.save(new Grade(
                gradeAddRequest.getWeight(),
                gradeAddRequest.getComment(),
                gradeAddRequest.getDate(),
                student,
                register,
                gradeType,
                gradeValue
        ));

        return GradeAddResponse.builder()
                .grade_id(grade.getGrade_id())
                .comment(grade.getComment())
                .value(grade.getGrade_value_id().getValue())
                .type_value(grade.getGrade_type_id().getValue())
                .type_text(grade.getGrade_type_id().getText())
                .student_id(grade.getStudent_id().getStudent_id())
                .weight(grade.getWeight())
                .date(grade.getDate())
                .text(grade.getGrade_value_id().getText())
                .build();
    }

    public void updateGrade(GradeUpdateRequest gradeUpdateRequest) {
        GradeType gradeType = gradeTypeRepository.findById(gradeUpdateRequest.getGrade_type_id()).orElseThrow(() -> new IllegalStateException("Typ oceny o id " + gradeUpdateRequest.getGrade_type_id() + " nie istnieje."));
        GradeValue gradeValue = gradeValueRepository.findById(gradeUpdateRequest.getGrade_value_id()).orElseThrow(() -> new IllegalStateException("Wartość oceny o id " + gradeUpdateRequest.getGrade_value_id() + " nie istnieje."));
        Grade grade = gradeRepository.findById(gradeUpdateRequest.getGrade_id()).orElseThrow(() -> new IllegalStateException("Ocena o id " + gradeUpdateRequest.getGrade_id() + " nie istnieje."));

        if(gradeType.getGrade_type_id() != null
                && gradeType.getGrade_type_id().toString().length() > 0
                && !Objects.equals(grade.getGrade_type_id().getGrade_type_id(), gradeType.getGrade_type_id())) {
            grade.setGrade_type_id(gradeType);
        }

        if(gradeValue.getGrade_value_id() != null
                && gradeValue.getGrade_value_id().toString().length() > 0
                && !Objects.equals(grade.getGrade_value_id().getGrade_value_id(), gradeValue.getGrade_value_id())) {
            grade.setGrade_value_id(gradeValue);
        }

        if(gradeUpdateRequest.getWeight() != null
                && gradeUpdateRequest.getWeight().toString().length() > 0
                && !Objects.equals(grade.getWeight(), gradeUpdateRequest.getWeight())) {
            grade.setWeight(gradeUpdateRequest.getWeight());
        }

        if(gradeUpdateRequest.getComment() != null
                && gradeUpdateRequest.getComment().length() > 0
                && !Objects.equals(grade.getComment(), gradeUpdateRequest.getComment())) {
            grade.setComment(gradeUpdateRequest.getComment());
        }

        gradeRepository.save(grade);
    }

    public void deleteGrade(Long grade_id) {
        boolean exists = gradeRepository.existsById(grade_id);
        if(!exists){
            throw new IllegalStateException("Ocena o id " + grade_id + " nie istnieje.");
        }
        gradeRepository.deleteById(grade_id);
    }
}
