package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ApplicationValidator
        extends Function<Combinator.Application, ApplicationValidator.Result> {
    static ApplicationValidator validateApplication(){
        return application-> application.getId()!=null? Result.SUCCESS:
                Result.INVALID_APPLICATION_ID;
    }
    static ApplicationValidator ewsStatus(){
        return application-> "declined05".equals(application.getStatus())? Result.SUCCESS:
                Result.EWS_DECLINED;
    }
    static ApplicationValidator validApplicants(){
        return application-> Optional.ofNullable(application.getApplicants())
                .orElse(Collections.emptyList())
                .size()>0 ? Result.SUCCESS:
                Result.MISSING_APPLICANTS;
    }

    Predicate<Combinator.Applicant> cifPredicate =
            applicant-> Objects.nonNull(applicant.getCif()) && !applicant.getCif().isBlank();

    static ApplicationValidator isValidCIF(){
        return application-> application.getApplicants()
                .stream()
                .filter(cifPredicate)
                .toList().size()>0?
                    Result.SUCCESS: Result.CIF_EXCEPTION;
    }

    default ApplicationValidator and(ApplicationValidator other){
        return application->{
            Result result= this.apply(application);
            return result.equals(Result.SUCCESS) ? other.apply(application): result;
        };
    }

    enum Result{
        INVALID,
        EWS_DECLINED,
        EXPERIAN_DECLINED,
        OFAC_DECLINED,
        THROTHLING_DECLINED,
        OTP_REQUIRED,
        CIF_EXCEPTION,
        SUCCESS,
        MISSING_APPLICANTS,
        INVALID_APPLICATION_ID;
    }

}
