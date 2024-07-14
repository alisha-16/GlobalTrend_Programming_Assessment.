package LogAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("LogExecutionTime")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LogExecutionTimeProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(LogExecutionTime.class)) {
            if (element instanceof ExecutableElement) {
                ExecutableElement method = (ExecutableElement) element;

                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                        "Logging execution time of method: " + method.getSimpleName());
                logExecutionTime(method);
            }
        }
        return true;
    }

    private void logExecutionTime(ExecutableElement method) {

        long startTime = System.nanoTime();

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                "Execution time of method " + method.getSimpleName() + ": " + executionTime + " nanoseconds");
    }
}
