package tests;

import java.io.File;
import java.util.List;
import org.checkerframework.common.value.ValueChecker;
import org.checkerframework.framework.test.FrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;

/** Tests the constant value propagation type system without overflow. */
public class ValueIgnoreRangeOverflowTest extends FrameworkPerDirectoryTest {

    public ValueIgnoreRangeOverflowTest(List<File> testFiles) {
        super(
                testFiles,
                org.checkerframework.common.value.ValueChecker.class,
                "value",
                "-Anomsgtext",
                "-Astubs=statically-executable.astub",
                "-A" + ValueChecker.REPORT_EVAL_WARNS,
                "-A" + ValueChecker.IGNORE_RANGE_OVERFLOW);
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[] {"value", "all-systems", "value-ignore-range-overflow"};
    }
}
