package suite;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Format/output tests")
@SelectPackages({"Model", "Kontroler"})
@IncludeTags("format")
@ExcludeTags("menu")
public class SuiteFormatOutput { }
