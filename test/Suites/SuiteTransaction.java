package Suites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Transactions")
@SelectPackages({"Model", "Kontroler"})
@IncludeTags("transaction")
public class SuiteTransaction {
}

