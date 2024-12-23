package Driver;
import java.util.List;

import Entity.Employe;
import Service.EmpService;

public class Driver {
	public static void main(String args[]) {
		List<Employe> emps=EmpService.fetchAll();
		for (Employe employe : emps) {
			System.out.println(employe.getId()+": "+employe.getName()+": "+
		employe.getAge()+": "+employe.getSalary());
		}
	}
	}



