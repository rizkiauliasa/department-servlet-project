package com.department.aul.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.department.aul.models.Data;
import com.department.aul.models.Student;

public class StudentService {

	public List<Data> getData() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("S1", "first", "Dep 1", 35));
		studentList.add(new Student("S2", "second", "Dep 1", 70));
		studentList.add(new Student("S3", "third", "Dep 1", 60));
		studentList.add(new Student("S4", "fourth", "Dep 1", 90));
		studentList.add(new Student("S5", "fifth", "Dep 2", 30));
		studentList.add(new Student("S6", "sixth", "Dep 3", 32));
		studentList.add(new Student("S7", "seventh", "Dep 3", 70));
		studentList.add(new Student("S8", "eigth", "Dep 3", 20));

		Map<String, List<Student>> groupedStudents = new HashMap<>();
		for (Student student : studentList) {
			String department = student.getDepartment();
			groupedStudents.computeIfAbsent(department, k -> new ArrayList<>()).add(student);
		}

		Map<String, Double> percentages = new HashMap<>();
		for (String department : groupedStudents.keySet()) {
			List<Student> filteredStudent = groupedStudents.get(department).stream()
					.filter(student -> student.getMark() instanceof Integer && (Integer) student.getMark() >= 40)
					.collect(Collectors.toList());
			int studentPass = filteredStudent.size();
			int departmentStudents = groupedStudents.get(department).size();
			Double percentage = (double) (studentPass * 100 / departmentStudents);
			percentages.put(department, percentage);
		}

		List<Data> dataList = new ArrayList<>();
		for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
			Data data = new Data();
			String key = entry.getKey();
			data.setDepartment(key);
			List<String> studentId = new ArrayList<>();
			List<Integer> mark = new ArrayList<>();
			List<Student> students = entry.getValue();
			for (Student student : students) {
				studentId.add(student.getStudentId());
				mark.add(student.getMark());
			}
			data.setStudentId(studentId);
			data.setMark(mark);
			data.setPercentage(percentages.get(key));
			dataList.add(data);
		}
		dataList.sort(Comparator.comparing(Data::getDepartment));
		return dataList;
	}

}
