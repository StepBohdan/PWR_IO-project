package suite;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Fast smoke")
@SelectPackages({"Model", "Kontroler"})
@IncludeTags("fast")
@ExcludeTags("mock")
public class SuiteSmokeFastNoMock { }
