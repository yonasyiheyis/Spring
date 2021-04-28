package cs544.exercise13_1;

import java.time.LocalDate;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class CustomerAdvice {

	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
	public void emailafter(JoinPoint joinpoint, String email, String message) {
		System.out.println(new Date()+ " method= "+joinpoint.getSignature().getName()+ " address: "+ email+ " message: "+ message);
		System.out.println("Outgoing mail server: "+ ((EmailSender) joinpoint.getTarget()).getOutgoingMailServer()); 
	}
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		 StopWatch sw = new StopWatch();
		 sw.start(call.getSignature().getName());
		 Object retVal = call.proceed();
		 sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute "+ call.getSignature().getName()+ " "+ totaltime+"ms");
		return retVal;
		}


}
