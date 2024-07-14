package LogAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Make annotation accessible at runtime
@Target(ElementType.METHOD) // Annotation applicable to methods
public @interface LogExecutionTime {
    String value() default ""; // Optional value for additional description
}
