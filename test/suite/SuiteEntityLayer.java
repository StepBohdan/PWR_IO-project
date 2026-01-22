package suite;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Entity")
@SelectPackages({"Model", "Kontroler"})
@IncludeTags("entity")
public class SuiteEntityLayer { }
