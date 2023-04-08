package java8;

import java.time.LocalDate;
import java.util.List;

import static java8.ApplicationValidator.*;

public class Combinator {

    public static void main(String[] args) {

        Application app1=new Application();
        app1.setId("test1234");
        app1.setStatus("declined05");
        app1.setApplicants(List.of(new Applicant(""), new Applicant(null)));


        var result=
        validApplicants()
                .and(ewsStatus())
                .and(validateApplication())
                .and(isValidCIF())
                .apply(app1);

        System.out.println(result);

    }


    public static class Application{
        private String id;
        private String status;
        private List<Applicant> applicants;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public List<Applicant> getApplicants() {
            return applicants;
        }

        public void setApplicants(List<Applicant> applicants) {
            this.applicants = applicants;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class Applicant{
        private String name;
        private String lastname;
        private LocalDate dob;
        private String cif;


        public Applicant(String cif) {
            this.cif = cif;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCif() {
            return cif;
        }
    }
}
