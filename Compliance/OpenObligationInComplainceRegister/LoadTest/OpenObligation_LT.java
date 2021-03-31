
// *********************************************************************************************
//
// Automatically Generated Load Test Program
// -----------------------------------------
//
// Source: OpenObligation_LT.java
// Date  : 31 Mar 2021 08:50:40 PST
// Author: Apica ZebraTester V5.5-F / automatically generated
//
// Procedure Copyright by Apica
// All Rights Reserved
//
// http://www.apicasystem.com                                         http://www.zebratester.com
// *********************************************************************************************


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.*;
import dfischer.utils.AbstractInputFileReader;
import dfischer.utils.Base64Decoder;
import dfischer.utils.Base64Encoder;
import dfischer.utils.ConvertToDoubleNumber;
import dfischer.utils.ContentTokenExtractor;
import dfischer.utils.ContentTokenExtractorItem;
import dfischer.utils.Cookie;
import dfischer.utils.CookieHandler;
import dfischer.utils.DigestAuthContext;
import dfischer.utils.DNSCache;
import dfischer.utils.DNSTranslationTable;
import dfischer.utils.DynamicProtobufContentParser;
import dfischer.utils.ExternalParamFile;
import dfischer.utils.FileCache;
import dfischer.utils.GenericPluginInterface;
import dfischer.utils.GetRealTimeUserInputFieldsInterface;
import dfischer.utils.HtmlContentParser;
import dfischer.utils.HtmlHeaderCookieExtractor;
import dfischer.utils.HttpLoadTest;
import dfischer.utils.HttpLoadTestIncrementUserThread;
import dfischer.utils.HttpLoadTestUserContext;
import dfischer.utils.HttpSocketPool;
import dfischer.utils.HttpTestURL;
import dfischer.utils.HttpTestURLDNSContext;
import dfischer.utils.HttpTestURLThreadHandler;
import dfischer.utils.InlineScriptExecutionException;
import dfischer.utils.InlineScriptExecutor;
import dfischer.utils.InnerLoopContext;
import dfischer.utils.JSONHtmlBasedExtractor;
import dfischer.utils.JSONPathBasedExtractor;
import dfischer.utils.JSONPathBasedExtractorItem;
import dfischer.utils.Lib;
import dfischer.utils.LoadtestInlineScriptContext;
import dfischer.utils.LoadtestInlineScriptVar;
import dfischer.utils.LoadtestPluginClassLoader;
import dfischer.utils.LoadtestPluginContext;
import dfischer.utils.NextProxyConfig;
import dfischer.utils.ParseArgs;
import dfischer.utils.ParseUrl;
import dfischer.utils.PerformanceData;
import dfischer.utils.PerformanceDataTickExtension;
import dfischer.utils.ProtobufFieldAndValueElement;
import dfischer.utils.ProtobufLib;
import dfischer.utils.RealTimeUserInputField;
import dfischer.utils.ScreenshotImage;
import dfischer.utils.SetThreadStepInterface;
import dfischer.utils.SSLInit;
import dfischer.utils.SSLSessionCacheStatistic;
import dfischer.utils.SSLSessionCacheStatisticInterface;
import dfischer.utils.SuspendResumeInterface;
import dfischer.utils.SymmetricEncrypt;
import dfischer.utils.SymmetricEncryptContext;
import dfischer.utils.TextLineTokenExtractor;
import dfischer.utils.TextLineTokenExtractorItem;
import dfischer.utils.ThreadStepInterface;
import dfischer.utils.UserInputField;
import dfischer.utils.UserTransactionContext;
import dfischer.utils.UserTransactionRuntimeHandler;
import dfischer.utils.VarInputFileReader;
import dfischer.utils.VarRandomInputFileReader;
import dfischer.utils.VaryingLoadInterface;
import dfischer.utils.VaryingTestDurationInterface;
import dfischer.utils.XmlContentParser;
import dfischer.utils.XmlDoctypeCommentParser;
import dfischer.utils.ZoneTime;
import dfischer.proxysniffer.ProxySnifferVarSourceInlineScript;
import dfischer.utils.WebSocketPluginInterface;
import dfischer.utils.BoundaryBasedExtractor;
import dfischer.utils.BoundaryBasedExtractorItem;
import dfischer.utils.RegExpBasedExtractor;
import dfischer.utils.RegExpBasedExtractorItem;
import dfischer.utils.XpathBasedExtractor;
import dfischer.utils.XpathBasedExtractorItem;
import dfischer.proxysniffer.WebSocketData;
import dfischer.utils.HttpTestWebsocketContext;
import dfischer.websocket.*;
import replay.ReplaySnapShotsDump;


/**
 * Automatically generated load test program.
 */
public class OpenObligation_LT extends HttpLoadTest implements Runnable, ThreadStepInterface, SetThreadStepInterface, SSLSessionCacheStatisticInterface, VaryingLoadInterface, VaryingTestDurationInterface, SuspendResumeInterface, GetRealTimeUserInputFieldsInterface
{
	public static final String prxVersion = "V5.5-F";
	public static final int    prxCharEncoding = 3;                         // 1 = OS Default, 2 = ISO-8859-1, 3 = UTF-8
	public static final String testDescription = "correlated";

	public static String USER_AGENT_1 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:87.0) Gecko/20100101 Firefox/87.0";

	private static final boolean CONTAINS_PARALLEL_EXECUTED_URLS = true;
	private static final int MAX_PARALLEL_THREADS_PER_USER = 6;                       // default value for max. parallel executed URLs per user
	private static int maxParallelThreadsPerUser = MAX_PARALLEL_THREADS_PER_USER;     // configured value for max. parallel executed URLs per user

	private static final boolean CONTAINS_EXTERNAL_RESOURCES = false;       // note: external resources are typically additional Java library files (*.jar files) invoked by self-developed plug-ins. Consider that Input Files and the Main Class of Plug-Ins are NOT external resources in this context because ZebraTester knows already their declarations.

	// --- WebSocket Object ---
	WebSocketData webSocketData = null;                                     // WebSocket Object that contains data of recorded WebSocket frames.
	WebSocketPluginInterface[] webSocketPluginsForURL = null;               // all assiciated web socket plugins for specific URL.

	// --- proxy configuration ---
	private static boolean proxyEnabled = false;                             // if false: do not use a proxy server
	private static boolean proxyCacheDisabled = true;
	private static String  proxyHttpHost = "";
	private static int     proxyHttpPort = -1;
	private static String  proxyHttpsHost = "";
	private static int     proxyHttpsPort = -1;
	private static String  noProxyFor = "";
	private static String  proxyAuthorization = null;
	private static NextProxyConfig commonNextProxyConfig = null;
	private NextProxyConfig userNextProxyConfig = null;
	
	private static int plannedStartupDelay = 200;                           // startup delay between concurrent users in milliseconds, see main argument "-sdelay"
	private static int plannedTestDuration = -1;                            // planned load test duration in seconds, 0 = unlimited, see main argument "-d"
	private static int maxPlannedLoops = 0;  								// maximum planned loops per user, 0 = unlimited, see main argument "-maxloops"
	private static int pacing = 0;  								        // pacing for loops per user, 0 = no pacing, see main argument "-pacing"
	private static int plannedRequestTimeout = 0;                           // planned request timeout in seconds, see main argument "-t"
	private static int plannedConnectTimeout = 0;                           // planned TCP/IP socket connect timeout in seconds (default = use plannedRequestTimeout), see main argument "-tconnect"
	
	private static String defaultTimeZone = "PST";                          // use main argument -tz <timezone> to alter
	private static char defaultNumberGroupingSeparator = '\'';              // use main argument -dgs a|c to alter
	private static String sslProtocolVersion = "all";                       // applied ssl protocol version: "all" = v3/tls/tls11/tls12, use main argument -ssl to set a fixed protocol version
	private static boolean sslcmode = false;                                // support of deficient ssl servers, use main argument -sslcmode to enable
	private static boolean sslECC = true;                                   // elliptic curve cryptography (ECC) is enabled by default, use main argument -noECC to disable
	private static boolean sslSNI = true;                                   // server name indication (SNI) is enabled by default, use main argument -nosni to disable
	private static boolean sslSNICirical = false;                           // the SNI TLS extension is by default set as non-critical, use main argument -snicritical to set as critical
	private static boolean useTlsSessionTickets = false;                    // Session Tickets can only be used with TLS, use main argument -tlssessiontickets to set to use
	private static final long loopErrorDelay = 20;                          // error delay (in milliseconds) applied if a loop of a virtual user has failed
	private static final String THREAD_NAME = "T000000";                    // internal
	private static Integer dumpLock = new Integer(0);                       // internal
	private static Integer inputFileLock = new Integer(0);                  // internal
	private volatile int threadStep = ThreadStepInterface.THREAD_NO_STEP;   // internal
	private boolean urlCallPassed = false;                                  // internal
	private String localIpAddress = null;                                   // internal
	private static long downlinkBandwidth = 0;                              // max. downlink bandwidth per user. 0 = unlimited. use main argument -downlink <kbps> to alter
	private static long uplinkBandwidth = 0;                                // max. uplink bandwidth per user. 0 = unlimited. use main argument -uplink <kbps> to alter
	private static boolean dnsPerLoop = false;								// true if main argument "-dnsperloop" is set = perform new DNS resolves for each executed loop. normally false
	private HttpTestURLDNSContext userDNSContext = null;                    // user specific DNS context - normally null when no special DNS servers are used
	
	private static volatile boolean debugFailedLoops = false;               // true if main argument "-dfl" is set
	private static volatile boolean debugLoops = false;                     // true if main argument "-dl" is set
	private static volatile boolean debugHttp = false;                      // true if main argument "-dh" is set
	private static volatile boolean debugContent = false;                   // true if main argument "-dc" is set
	private static volatile boolean debugCookies = false;                   // true if main argument "-dC" is set
	private static volatile boolean debugKeepAlive = false;                 // true if main argument "-dK" is set
	private static volatile boolean debugSsl = false;                       // true if main argument "-dssl" is set
	
	private static String resultFile = null;                                // name of binary test result file or null
	private static String browserLanguage = null;                           // name of browser language, argument -browserlang <text>
	private static boolean replayMode = false;                              // indicated the replay mode of the load test, use main argument -replay to enable it
	
	private final static String httpProtocolVersion = "1.1";      // applied HTTP protocol version V1.1
	
	private static ExternalParamFile externalParamFile = null;                              // used only for very large parameter values (commonly unused)
	private static final String EXTERNAL_PARAM_FILE = "OpenObligation_LTExtParams.dat";     // input file name for very large parameter values
	private static FileCache requestFileCache = new FileCache();  // file cache for large XML, SOAP and ASCII requests
	
	private int requestTimeout = -1;                              // thread input data from constructor, timeout per url request in seconds
	private int remainingLoops = -1;                              // thread input data from constructor, number of loops per thread (optional)
	private boolean checkLoopCount = false;                       // thread input data from constructor, number of loops per thread (optional)
	private int threadNumber = -1;                                // thread input data from constructor, internal thread number
	private int threadLoopCounter = 0;                            // internal loop counter per thread
	private volatile int userResumeStartWaitDelay = 0;            // internal, user specific delay when the load test execution is resumed
	private volatile boolean decrementEndOfLoopFlag = false;	  // internal flag to decrement the simulated user at runtime
	private volatile boolean incrementUserFlag = false;           // internal flag to increment the simulated user at runtime
	private volatile long incrementUserStartTime = -1;            // internal start time when increment the simulated user at runtime
	private static AtomicInteger totalLoopCounter = new AtomicInteger(0);    // internal overall loop counter

	private LoadtestPluginContext userPluginContext = null;       // plug-in context per user
	private LoadtestInlineScriptContext inlineScriptContext = null;          // re-used, scratch, the returned context of an inline script that runs at item or URL exec scope

	private Object sslSessionCache = null;                        // internal ssl session cache per thread
	private SSLSessionCacheStatistic sslStatistic = null;         // internal ssl session cache statistic per thread
	private static int sslSessionCacheTimeout = 300;              // timeout of ssl session cache in seconds, 0 = session cache disabled
	private static int sslHandshakeRandomGeneratorType = -1;      // invalid initial value, use the default secure random generator for SSL handshakes
	private HttpSocketPool socketPool = null;                     // re-used, scratch, internal socket pool per thread and loop
	private CookieHandler cookieHandler = null;                   // re-used, scratch, internal cookie handler per thread and loop

	private HttpTestURL testURL = null;                           // re-used, scratch, http request and response
	private HttpTestURLThreadHandler pageThreadHandler = null;    // re-used, scratch, support for parallel processing of http request within a page
	private int httpStatus = -1;                                  // re-used, scratch, http response status code from webserver
	private HtmlContentParser htmlContentParser = null;           // re-used, scratch, used to extract vars from http response
	private XmlContentParser xmlContentParser = null;             // re-used, scratch, used to extract vars from http response
	private JSONHtmlBasedExtractor jsonHtmlBasedExtractor = null; // re-used, scratch, used to extract vars from http response
	private DynamicProtobufContentParser protobufContentParser = null;  // re-used, scratch, used to extract vars from http response
	private TextLineTokenExtractor textLineTokenExtractor = null; // re-used, scratch, used to extract vars from http response
	private ContentTokenExtractor contentTokenExtractor = null;   // re-used, scratch, used to extract vars from http response
	private BoundaryBasedExtractor boundaryBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private RegExpBasedExtractor regExpBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private XpathBasedExtractor xpathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	private JSONPathBasedExtractor jsonPathBasedExtractor = null;   // re-used, scratch, used to extract vars from http response
	
	private static VarInputFileReader P_Username_txt = null;         // input file P_Username.txt, file scope: new line per user

	private volatile UserTransactionRuntimeHandler transactionHandler = new UserTransactionRuntimeHandler();		// re-used, support to manage user-defined transactions
	private Map<String,String> transactionContextMap = new HashMap<>();		// used to correctly measure the user-defined transactions

	private String P_Username = null;                                     // var declaration from web admin var handler: scope = per user

	private String C_Timestamp1 = null;                  // var declaration from web admin var handler: scope = per loop
	private String C_JSVersion = null;                   // var declaration from web admin var handler: scope = per loop
	
	/**
	 * constructor: called from load test plug-ins (scope = global).
	 */
	public OpenObligation_LT()
	{
		super();
	}


	/**
	 * constructor: called when a user is created (per user).
	 */
	public OpenObligation_LT(int maxLoops, int requestTimeout, int threadNumber)
	{
		super();
		this.requestTimeout = requestTimeout;
		this.remainingLoops = maxLoops;
		this.checkLoopCount = (maxLoops > 0);
		this.threadNumber = threadNumber;
		this.sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);
		this.sslStatistic = new SSLSessionCacheStatistic();
		if (isMultihomed() && (!ipPerLoop()))
			this.localIpAddress = getNextMultihomedIpAddress();
		if (dnsCache != null)
			userDNSContext = new HttpTestURLDNSContext(dnsCache, threadNumber);
		
		// read next line from input file: scope = per user
		try
		{
			synchronized (inputFileLock)
			{
				if (!P_Username_txt.getNextLine())
					abortByEofInputFile();
				// extract vars from input file: scope = per user
				P_Username = new String(P_Username_txt.getLineVar(1));
			}
		}
		catch (Exception ie)
		{
			abortByEofInputFile();
		}
		
		applyNextProxySettingsFromFileIfExists();
		
		if (commonNextProxyConfig != null)
			// set proxy configuration data per user 
			userNextProxyConfig = new NextProxyConfig(commonNextProxyConfig);
		
		// initialize context for plug-ins which are executed per user
		userPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber);
		if(replayMode)
		{
			replaySnapShotsDump = new ReplaySnapShotsDump();
		}
	}


	/**
	 * internal method: called when a user starts a loop.
	 * contains the recorded session which is called by users x loops.
	 * 
	 * @param totalLoopCounter total number of loops (0..n-1) counted overall threads. This value is unique per loop.
	 * 
	 * @return  true:  loop successful completed.
	 *          false: loop failed.
	 */
	private boolean execute(int totalLoopCounter) throws Exception
	{
		markStartOfLoop();
		threadStep = 0;                 // internal - start loop at thread step 0
		
		// enable DNS resolves per loop?
		if (dnsPerLoop)
			userDNSContext = new HttpTestURLDNSContext(dnsCache.clone(false), threadNumber);
		
		// debug http headers?
		Object httpLogVectorObject = null;
		if (debugHttp)
			httpLogVectorObject = this;
		
		// create socket pool per loop
		sslSessionCache = SSLInit.getNewSslSessionCache(sslSessionCacheTimeout);		// reset the SSL session cache to get new SSL session IDs for this loop
		socketPool = new HttpSocketPool(this, sslProtocolVersion, sslSessionCache, sslStatistic, sslcmode);
		if (plannedConnectTimeout > 0)
			socketPool.setConnectTimeout(plannedConnectTimeout);
		if (sslHandshakeRandomGeneratorType != -1)
			socketPool.setSslHandshakeRandomGeneratorType(sslHandshakeRandomGeneratorType);
		socketPool.setSupportEllipticCurves(sslECC);
		socketPool.setHintUseSNI(sslSNI);
		socketPool.setSniCritical(sslSNICirical);
		socketPool.setUseTlsSessionTickets(useTlsSessionTickets);
		if (debugKeepAlive)
		{
			socketPool.setlogVectorObject(this);
			if (debugSsl)
				socketPool.enableSslLog();
		}
		
		if (downlinkBandwidth > 0)
			socketPool.setDownlinkBandwidth(downlinkBandwidth);
		if (uplinkBandwidth > 0)
			socketPool.setUplinkBandwidth(uplinkBandwidth);
		
		if (isMultihomed())
		{
			if (ipPerLoop())
				localIpAddress = getNextMultihomedIpAddress();
			socketPool.setClientIpAddress(localIpAddress);
			log();
			log("multihomed client ip address = " + localIpAddress);
		}
		
		// setup cookie handler per loop
		cookieHandler = new CookieHandler();
		if (debugCookies)
			cookieHandler.setLogVectorInterface(this);
		
		// customised vars from web admin var handler: scope = per user
		log();
		log("<<< P_Username = " + P_Username);
		
		// customised vars from web admin var handler: scope = per loop
		htmlContentParser = null;
		xmlContentParser = null;
		jsonHtmlBasedExtractor = null;
		protobufContentParser = null;
		C_Timestamp1 = null;
		C_JSVersion = null;
		log();
		log("<<< C_Timestamp1 = " + C_Timestamp1);
		log("<<< C_JSVersion = " + C_JSVersion);
		
		// initialize context for plug-ins which are executed per loop
		LoadtestPluginContext loopPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, this, threadNumber, socketPool, cookieHandler);
		



		// --- VIRTUAL PAGE #0 ---
		if (!executePage_0(totalLoopCounter, loopPluginContext, new InnerLoopContext(), 0,0, httpLogVectorObject))
			return false;



		// --- PAGE BREAK: Test [0] ---
		log();
		log();
		log("# Page #1: LaunchURL");
		log("# ------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #1: LaunchURL", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_1_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 1 failed
			synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 1 failed
		
		// page 1 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [49] ---
		log();
		log();
		log("# Page #2: IsometrixSignInPage");
		log("# ----------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #2: IsometrixSignInPage", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 2 failed
			synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 2 failed
		
		// page 2 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [60] ---
		log();
		log();
		log("# Page #3: Login");
		log("# --------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #3: Login", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_2(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_3_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 3 failed
			synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_3(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 3 failed
		
		// page 3 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [156] ---
		log();
		log();
		log("# Page #4: TeckStandardInterface");
		log("# ------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #4: TeckStandardInterface", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 4 failed
			synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_4(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 4 failed
		
		// page 4 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [161] ---
		log();
		log();
		log("# Page #5: Compliance");
		log("# -------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #5: Compliance", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 5 failed
			synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_5(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 5 failed
		
		// page 5 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [163] ---
		log();
		log();
		log("# Page #6: ComplianceRegister");
		log("# ---------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #6: ComplianceRegister", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 6 failed
			synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!executePage_6_1(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 6 failed
			synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_6(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 6 failed
		
		// page 6 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [204] ---
		log();
		log();
		log("# Page #7: Search");
		log("# ---------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #7: Search", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 7 failed
			synchResponsesParallelRequestsPage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_7(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 7 failed
		
		// page 7 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [206] ---
		log();
		log();
		log("# Page #8: selectQB2");
		log("# ------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #8: selectQB2", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 8 failed
			synchResponsesParallelRequestsPage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_8(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 8 failed
		
		// page 8 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [213] ---
		log();
		log();
		log("# Page #9: OpenRCASourceDoc");
		log("# -------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #9: OpenRCASourceDoc", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_9(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 9 failed
			synchResponsesParallelRequestsPage_9(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_9(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 9 failed
		
		// page 9 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [223] ---
		log();
		log();
		log("# Page #10: OpenObligation");
		log("# ------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #10: OpenObligation", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_10(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 10 failed
			synchResponsesParallelRequestsPage_10(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_10(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 10 failed
		
		// page 10 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [233] ---
		log();
		log();
		log("# Page #11: CloseRecord");
		log("# ---------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #11: CloseRecord", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_11(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 11 failed
			synchResponsesParallelRequestsPage_11(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_11(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 11 failed
		
		// page 11 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [237] ---
		log();
		log();
		log("# Page #12: CloseSourceDoc");
		log("# ------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #12: CloseSourceDoc", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_12(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 12 failed
			synchResponsesParallelRequestsPage_12(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_12(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 12 failed
		
		// page 12 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [242] ---
		log();
		log();
		log("# Page #13: closeComplianceRegister");
		log("# ---------------------------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #13: closeComplianceRegister", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_13(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 13 failed
			synchResponsesParallelRequestsPage_13(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_13(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 13 failed
		
		// page 13 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);



		// --- PAGE BREAK: Test [244] ---
		log();
		log();
		log("# Page #14: LogOut");
		log("# ----------------");
		threadStep = setPageBreak(performanceData, threadStep, "Page #14: LogOut", 3000, 35, -1);		// hint: param #4 is the user's think time in milliseconds, param #5 is randomness of the user's think time in percent (+/- 0..100%), param #6 is the maximum acceptable response time in milliseconds (-1 = not configured)
		pageThreadHandler = new HttpTestURLThreadHandler(threadStep - 1, maxParallelThreadsPerUser, performanceData, this);   // support for parallel processing of http(s) requests within a page. hint: param #2 is the number of parallel threads per user
		log();

		if (!executePage_14(totalLoopCounter, loopPluginContext, new InnerLoopContext(),0,0, httpLogVectorObject))
		{
			// execution of page 14 failed
			synchResponsesParallelRequestsPage_14(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject);
			return false;
		}
		if (!synchResponsesParallelRequestsPage_14(totalLoopCounter, loopPluginContext, new InnerLoopContext(), httpLogVectorObject))
			return false;		// execution of page 14 failed
		
		// page 14 successfully executed
		pageThreadHandler.addPageResponseTimeToResult(this);
		
		
		// loop successful done
		// --------------------
		
		markEndOfPage(performanceData);
		
		endOfExecuteLoop(true, null, -1, loopPluginContext);
		log();
		return true;
	}		// end of execute()
		
		
		
	/**
	 * internal method: called when a user has completed a loop.
	 */
	private void endOfExecuteLoop(boolean loopPassed, HttpTestURL testURL, int threadStep, LoadtestPluginContext loopPluginContext) throws Exception
	{
		// log URL if last call has failed
		if ((!loopPassed) && (testURL != null))
			log(testURL);
		
		// update plugin context
		loopPluginContext.setLoopPassed(loopPassed);
		if ((testURL != null) && (loopPluginContext.getHttpTestURL() == null))
			loopPluginContext.setHttpTestURL(testURL);
		if ((threadStep != -1) && (loopPluginContext.getThreadStep() == -1))
			loopPluginContext.setThreadStep(threadStep);
	}


	/**
	 * Recorded http requests of page #0.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_0(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{

		// all http requests of page #0 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #1: LaunchURL
		// # ------------------



		// --- HTTP REQUEST: Test [1] <- WEB ADMIN Index 1 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0001 = "https";
		String requestHost0001 = "preprod-teck.isometrix.net";
		int    requestPort0001 = 443;
		String requestFile0001 = "/mixedmode.aspx";
		String requestHeader0001 = "GET " + requestFile0001 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0001, requestHost0001, requestPort0001, requestHeader0001, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0001 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 4448
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Login Checks");		// Test [1] <- Index 1
		if(replayMode)
		{
			long proxyDataRecordId =1617042154089L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_JSVersion'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0001_1 = new BoundaryBasedExtractorItem( "head.js?_=" , "\" type=\"text/javascript\">",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0001_1);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_JSVersion'
			C_JSVersion = boundaryBasedContentExtractorItem0001_1.getResultText();
			log("<<< C_JSVersion = " + C_JSVersion);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_JSVersion!= null && C_JSVersion.trim().length() == 0)
			{
				C_JSVersion = "";
				log("runtime note: the extraction of a new value for the variable 'C_JSVersion' ends up with an empty string - a substitute value was set");
				log("<<< C_JSVersion = " + C_JSVersion);
			}
		}
		catch (Exception e) { C_JSVersion = null; log(e); }
		if (C_JSVersion == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_JSVersion' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [2] <- WEB ADMIN Index 2 ---
		String requestProt0002 = "https";
		String requestHost0002 = "preprod-teck.isometrix.net";
		int    requestPort0002 = 443;
		String requestFile0002 = "/css/page.login.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0002 = Lib.replaceTextPattern(requestFile0002, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0002 = "GET " + requestFile0002 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0002, requestHost0002, requestPort0002, requestHeader0002, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0002 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [3] <- WEB ADMIN Index 3 ---
		String requestProt0003 = "https";
		String requestHost0003 = "preprod-teck.isometrix.net";
		int    requestPort0003 = 443;
		String requestFile0003 = "/css/core.grid.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0003 = Lib.replaceTextPattern(requestFile0003, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0003 = "GET " + requestFile0003 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0003, requestHost0003, requestPort0003, requestHeader0003, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0003 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [4] <- WEB ADMIN Index 4 ---
		String requestProt0004 = "https";
		String requestHost0004 = "preprod-teck.isometrix.net";
		int    requestPort0004 = 443;
		String requestFile0004 = "/css/core.jstree.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0004 = Lib.replaceTextPattern(requestFile0004, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0004 = "GET " + requestFile0004 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0004, requestHost0004, requestPort0004, requestHeader0004, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0004 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [5] <- WEB ADMIN Index 5 ---
		String requestProt0005 = "https";
		String requestHost0005 = "preprod-teck.isometrix.net";
		int    requestPort0005 = 443;
		String requestFile0005 = "/css/core.icons.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0005 = Lib.replaceTextPattern(requestFile0005, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0005 = "GET " + requestFile0005 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0005, requestHost0005, requestPort0005, requestHeader0005, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0005 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [6] <- WEB ADMIN Index 6 ---
		String requestProt0006 = "https";
		String requestHost0006 = "preprod-teck.isometrix.net";
		int    requestPort0006 = 443;
		String requestFile0006 = "/scripts/core.head.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0006 = Lib.replaceTextPattern(requestFile0006, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0006 = "GET " + requestFile0006 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0006, requestHost0006, requestPort0006, requestHeader0006, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0006 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [7] <- WEB ADMIN Index 7 ---
		String requestProt0007 = "https";
		String requestHost0007 = "preprod-teck.isometrix.net";
		int    requestPort0007 = 443;
		String requestFile0007 = "/css/core.buttons.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0007 = Lib.replaceTextPattern(requestFile0007, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0007 = "GET " + requestFile0007 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0007, requestHost0007, requestPort0007, requestHeader0007, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0007 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [8] <- WEB ADMIN Index 8 ---
		String requestProt0008 = "https";
		String requestHost0008 = "incoming.telemetry.mozilla.org";
		int    requestPort0008 = 443;
		String requestFile0008 = "/submit/activity-stream/impression-stats/1/bd11ab92-d298-470b-898c-4b81202ba207";
		String requestContent0008 = 
				"{\"experiments\":{\"bug-1680034-rollout-shirley-feature-roll-out-81-to-83-release-81-83\":{\"branch\":\"active\"},\"rollout-increasing-normandy-skew-out-changes-from-15-m-release-73-75-bug-1616898\":{\"branch\":\"active\"}},\"locale\":\"en-US\",\"version\":\"87.0\",\"release_channel\":\"release\",\"addon_version\":\"20210318103112\",\"user_prefs\":511,\"page\":\"about:newtab\",\"source\":\"CARDGRID\",\"tiles\":[{\"id\":88711,\"pos\":1},{\"id\":88769,\"pos\":0},{\"id\":88765,\"pos\":2}],\"impression_id\":\"{70d0eae6-f64d-47cd-9ce9-c58bb4dea5de}\"}";
		byte[] requestContentBinary0008 = requestContent0008.getBytes("UTF-8");
		String requestHeader0008 = "POST " + requestFile0008 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: incoming.telemetry.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=UTF-8\r\n" + 
				"Content-Encoding: gzip\r\n" + 
				"Date: Mon, 29 Mar 2021 18:22:34 GMT\r\n" + 
				"Content-Length: " + requestContentBinary0008.length + "\r\n" + 		// Content-Length: 494
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0008, requestHost0008, requestPort0008, requestHeader0008, requestContentBinary0008, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0008 = null;		// support garbage collector to reduce memory
		requestContent0008 = null;		// support garbage collector to reduce memory
		requestContentBinary0008 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [8] <- Index 8
		if(replayMode)
		{
			long proxyDataRecordId =1617042155336L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [9] <- WEB ADMIN Index 9 ---
		String requestProt0009 = "https";
		String requestHost0009 = "incoming.telemetry.mozilla.org";
		int    requestPort0009 = 443;
		String requestFile0009 = "/submit/activity-stream/sessions/1/e933f8b8-fb9b-4931-8934-55314b2e5599";
		String requestContent0009 = 
				"{\"experiments\":{\"bug-1680034-rollout-shirley-feature-roll-out-81-to-83-release-81-83\":{\"branch\":\"active\"},\"rollout-increasing-normandy-skew-out-changes-from-15-m-release-73-75-bug-1616898\":{\"branch\":\"active\"}},\"locale\":\"en-US\",\"version\":\"87.0\",\"release_channel\":\"release\",\"addon_version\":\"20210318103112\",\"user_prefs\":511,\"session_id\":\"{e0c713bc-0542-492d-b609-72206ce53d1c}\",\"page\":\"about:newtab\",\"session_duration\":88871,\"perf\":{\"load_trigger_type\":\"unexpected\",\"is_preloaded\":true,\"topsites_icon_stats\":{\"custom_screenshot\":0,\"screenshot_with_icon\":4,\"screenshot\":2,\"tippytop\":0,\"rich_icon\":2,\"no_image\":0},\"topsites_pinned\":0,\"topsites_search_shortcuts\":0,\"topsites_first_painted_ts\":1617042056880,\"visibility_event_rcvd_ts\":1617042065659,\"load_trigger_ts\":-1},\"profile_creation_date\":18159,\"client_id\":\"82992477-42b5-4560-80f8-a38f509e8385\"}";
		byte[] requestContentBinary0009 = requestContent0009.getBytes("UTF-8");
		String requestHeader0009 = "POST " + requestFile0009 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: incoming.telemetry.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=UTF-8\r\n" + 
				"Content-Encoding: gzip\r\n" + 
				"Date: Mon, 29 Mar 2021 18:22:34 GMT\r\n" + 
				"Content-Length: " + requestContentBinary0009.length + "\r\n" + 		// Content-Length: 846
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0009, requestHost0009, requestPort0009, requestHeader0009, requestContentBinary0009, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0009 = null;		// support garbage collector to reduce memory
		requestContent0009 = null;		// support garbage collector to reduce memory
		requestContentBinary0009 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [9] <- Index 9
		if(replayMode)
		{
			long proxyDataRecordId =1617042155341L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [10] <- WEB ADMIN Index 10 ---
		String requestProt0010 = "https";
		String requestHost0010 = "preprod-teck.isometrix.net";
		int    requestPort0010 = 443;
		String requestFile0010 = "/css/core.ui.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0010 = Lib.replaceTextPattern(requestFile0010, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0010 = "GET " + requestFile0010 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0010, requestHost0010, requestPort0010, requestHeader0010, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0010 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [11] <- WEB ADMIN Index 11 ---
		String requestProt0011 = "https";
		String requestHost0011 = "incoming.telemetry.mozilla.org";
		int    requestPort0011 = 443;
		String requestFile0011 = "/submit/activity-stream/impression-stats/1/39ca7a8c-1996-462e-8dba-e3d20bb2b9ee";
		String requestContent0011 = 
				"{\"experiments\":{\"bug-1680034-rollout-shirley-feature-roll-out-81-to-83-release-81-83\":{\"branch\":\"active\"},\"rollout-increasing-normandy-skew-out-changes-from-15-m-release-73-75-bug-1616898\":{\"branch\":\"active\"}},\"locale\":\"en-US\",\"version\":\"87.0\",\"release_channel\":\"release\",\"addon_version\":\"20210318103112\",\"user_prefs\":511,\"page\":\"about:newtab\",\"source\":\"CARDGRID\",\"tiles\":[{\"id\":88711,\"pos\":1},{\"id\":88765,\"pos\":2},{\"id\":88769,\"pos\":0},{\"id\":88703,\"pos\":3},{\"id\":88741,\"pos\":4},{\"id\":88682,\"pos\":5},{\"id\":88733,\"pos\":6},{\"id\":88678,\"pos\":7},{\"id\":88745,\"pos\":8},{\"id\":88749,\"pos\":9},{\"id\":88576,\"pos\":10},{\"id\":88588,\"pos\":11},{\"id\":88695,\"pos\":12},{\"id\":88690,\"pos\":13},{\"id\":88597,\"pos\":14},{\"id\":88592,\"pos\":15},{\"id\":88630,\"pos\":16},{\"id\":88674,\"pos\":17},{\"id\":88646,\"pos\":18},{\"id\":88622,\"pos\":19},{\"id\":88686,\"pos\":20}],\"loaded\":21,\"impression_id\":\"{70d0eae6-f64d-47cd-9ce9-c58bb4dea5de}\"}";
		byte[] requestContentBinary0011 = requestContent0011.getBytes("UTF-8");
		String requestHeader0011 = "POST " + requestFile0011 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: incoming.telemetry.mozilla.org\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=UTF-8\r\n" + 
				"Content-Encoding: gzip\r\n" + 
				"Date: Mon, 29 Mar 2021 18:22:34 GMT\r\n" + 
				"Content-Length: " + requestContentBinary0011.length + "\r\n" + 		// Content-Length: 895
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0011, requestHost0011, requestPort0011, requestHeader0011, requestContentBinary0011, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0011 = null;		// support garbage collector to reduce memory
		requestContent0011 = null;		// support garbage collector to reduce memory
		requestContentBinary0011 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/PLAIN", header text fragment = [verification disabled], recorded content size = 0
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/PLAIN", null, null);		// Test [11] <- Index 11
		if(replayMode)
		{
			long proxyDataRecordId =1617042155348L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [12] <- WEB ADMIN Index 12 ---
		String requestProt0012 = "https";
		String requestHost0012 = "preprod-teck.isometrix.net";
		int    requestPort0012 = 443;
		String requestFile0012 = "/css/core.layout.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0012 = Lib.replaceTextPattern(requestFile0012, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0012 = "GET " + requestFile0012 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0012, requestHost0012, requestPort0012, requestHeader0012, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0012 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [13] <- WEB ADMIN Index 13 ---
		String requestProt0013 = "https";
		String requestHost0013 = "preprod-teck.isometrix.net";
		int    requestPort0013 = 443;
		String requestFile0013 = "/css/core.jstree.overrides.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0013 = Lib.replaceTextPattern(requestFile0013, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0013 = "GET " + requestFile0013 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0013, requestHost0013, requestPort0013, requestHeader0013, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0013 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [14] <- WEB ADMIN Index 14 ---
		String requestProt0014 = "https";
		String requestHost0014 = "preprod-teck.isometrix.net";
		int    requestPort0014 = 443;
		String requestFile0014 = "/css/core.select3.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0014 = Lib.replaceTextPattern(requestFile0014, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0014 = "GET " + requestFile0014 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0014, requestHost0014, requestPort0014, requestHeader0014, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0014 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [15] <- WEB ADMIN Index 15 ---
		String requestProt0015 = "https";
		String requestHost0015 = "preprod-teck.isometrix.net";
		int    requestPort0015 = 443;
		String requestFile0015 = "/css/kendo/kendo.common.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0015 = Lib.replaceTextPattern(requestFile0015, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0015 = "GET " + requestFile0015 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0015, requestHost0015, requestPort0015, requestHeader0015, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0015 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [16] <- WEB ADMIN Index 16 ---
		String requestProt0016 = "https";
		String requestHost0016 = "preprod-teck.isometrix.net";
		int    requestPort0016 = 443;
		String requestFile0016 = "/css/kendo/kendo.default.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0016 = Lib.replaceTextPattern(requestFile0016, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0016 = "GET " + requestFile0016 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0016, requestHost0016, requestPort0016, requestHeader0016, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0016 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [17] <- WEB ADMIN Index 17 ---
		String requestProt0017 = "https";
		String requestHost0017 = "preprod-teck.isometrix.net";
		int    requestPort0017 = 443;
		String requestFile0017 = "/css/kendo/kendo.material.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0017 = Lib.replaceTextPattern(requestFile0017, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0017 = "GET " + requestFile0017 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0017, requestHost0017, requestPort0017, requestHeader0017, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0017 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [18] <- WEB ADMIN Index 18 ---
		String requestProt0018 = "https";
		String requestHost0018 = "preprod-teck.isometrix.net";
		int    requestPort0018 = 443;
		String requestFile0018 = "/css/kendo/kendo.custom.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0018 = Lib.replaceTextPattern(requestFile0018, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0018 = "GET " + requestFile0018 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0018, requestHost0018, requestPort0018, requestHeader0018, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0018 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [19] <- WEB ADMIN Index 19 ---
		String requestProt0019 = "https";
		String requestHost0019 = "preprod-teck.isometrix.net";
		int    requestPort0019 = 443;
		String requestFile0019 = "/css/semantic/loader.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0019 = Lib.replaceTextPattern(requestFile0019, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0019 = "GET " + requestFile0019 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0019, requestHost0019, requestPort0019, requestHeader0019, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0019 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [20] <- WEB ADMIN Index 20 ---
		String requestProt0020 = "https";
		String requestHost0020 = "preprod-teck.isometrix.net";
		int    requestPort0020 = 443;
		String requestFile0020 = "/css/semantic/dimmer.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0020 = Lib.replaceTextPattern(requestFile0020, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0020 = "GET " + requestFile0020 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0020, requestHost0020, requestPort0020, requestHeader0020, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0020 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 2 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [21] <- WEB ADMIN Index 21 ---
		String requestProt0021 = "https";
		String requestHost0021 = "preprod-teck.isometrix.net";
		int    requestPort0021 = 443;
		String requestFile0021 = "/css/semantic/transition.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0021 = Lib.replaceTextPattern(requestFile0021, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0021 = "GET " + requestFile0021 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0021, requestHost0021, requestPort0021, requestHeader0021, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0021 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [22] <- WEB ADMIN Index 22 ---
		String requestProt0022 = "https";
		String requestHost0022 = "preprod-teck.isometrix.net";
		int    requestPort0022 = 443;
		String requestFile0022 = "/css/semantic/icon.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0022 = Lib.replaceTextPattern(requestFile0022, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0022 = "GET " + requestFile0022 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0022, requestHost0022, requestPort0022, requestHeader0022, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0022 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [23] <- WEB ADMIN Index 23 ---
		String requestProt0023 = "https";
		String requestHost0023 = "preprod-teck.isometrix.net";
		int    requestPort0023 = 443;
		String requestFile0023 = "/components/theme/templates/theme.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0023 = Lib.replaceTextPattern(requestFile0023, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0023 = "GET " + requestFile0023 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0023, requestHost0023, requestPort0023, requestHeader0023, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0023 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [24] <- WEB ADMIN Index 24 ---
		String requestProt0024 = "https";
		String requestHost0024 = "preprod-teck.isometrix.net";
		int    requestPort0024 = 443;
		String requestFile0024 = "/scripts/core.namespace.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0024 = Lib.replaceTextPattern(requestFile0024, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0024 = "GET " + requestFile0024 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0024, requestHost0024, requestPort0024, requestHeader0024, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0024 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [25] <- WEB ADMIN Index 25 ---
		String requestProt0025 = "https";
		String requestHost0025 = "preprod-teck.isometrix.net";
		int    requestPort0025 = 443;
		String requestFile0025 = "/scripts/core.common.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0025 = Lib.replaceTextPattern(requestFile0025, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0025 = "GET " + requestFile0025 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0025, requestHost0025, requestPort0025, requestHeader0025, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0025 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [26] <- WEB ADMIN Index 26 ---
		String requestProt0026 = "https";
		String requestHost0026 = "preprod-teck.isometrix.net";
		int    requestPort0026 = 443;
		String requestFile0026 = "/scripts/core.jquery.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0026 = Lib.replaceTextPattern(requestFile0026, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0026 = "GET " + requestFile0026 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0026, requestHost0026, requestPort0026, requestHeader0026, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0026 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [27] <- WEB ADMIN Index 27 ---
		String requestProt0027 = "https";
		String requestHost0027 = "preprod-teck.isometrix.net";
		int    requestPort0027 = 443;
		String requestFile0027 = "/scripts/core.lang.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0027 = Lib.replaceTextPattern(requestFile0027, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0027 = "GET " + requestFile0027 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0027, requestHost0027, requestPort0027, requestHeader0027, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0027 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [28] <- WEB ADMIN Index 28 ---
		String requestProt0028 = "https";
		String requestHost0028 = "preprod-teck.isometrix.net";
		int    requestPort0028 = 443;
		String requestFile0028 = "/components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0028 = Lib.replaceTextPattern(requestFile0028, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0028 = "GET " + requestFile0028 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0028, requestHost0028, requestPort0028, requestHeader0028, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0028 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [29] <- WEB ADMIN Index 29 ---
		String requestProt0029 = "https";
		String requestHost0029 = "preprod-teck.isometrix.net";
		int    requestPort0029 = 443;
		String requestFile0029 = "/scripts/core.ui.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0029 = Lib.replaceTextPattern(requestFile0029, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0029 = "GET " + requestFile0029 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0029, requestHost0029, requestPort0029, requestHeader0029, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0029 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [30] <- WEB ADMIN Index 30 ---
		String requestProt0030 = "https";
		String requestHost0030 = "preprod-teck.isometrix.net";
		int    requestPort0030 = 443;
		String requestFile0030 = "/scripts/core.lodash.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0030 = Lib.replaceTextPattern(requestFile0030, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0030 = "GET " + requestFile0030 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0030, requestHost0030, requestPort0030, requestHeader0030, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0030 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [31] <- WEB ADMIN Index 31 ---
		String requestProt0031 = "https";
		String requestHost0031 = "preprod-teck.isometrix.net";
		int    requestPort0031 = 443;
		String requestFile0031 = "/scripts/core.utilities.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0031 = Lib.replaceTextPattern(requestFile0031, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0031 = "GET " + requestFile0031 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0031, requestHost0031, requestPort0031, requestHeader0031, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0031 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [32] <- WEB ADMIN Index 32 ---
		String requestProt0032 = "https";
		String requestHost0032 = "preprod-teck.isometrix.net";
		int    requestPort0032 = 443;
		String requestFile0032 = "/scripts/core.ajax.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0032 = Lib.replaceTextPattern(requestFile0032, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0032 = "GET " + requestFile0032 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0032, requestHost0032, requestPort0032, requestHeader0032, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0032 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [33] <- WEB ADMIN Index 33 ---
		String requestProt0033 = "https";
		String requestHost0033 = "preprod-teck.isometrix.net";
		int    requestPort0033 = 443;
		String requestFile0033 = "/scripts/core.session.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0033 = Lib.replaceTextPattern(requestFile0033, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0033 = "GET " + requestFile0033 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0033, requestHost0033, requestPort0033, requestHeader0033, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0033 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [34] <- WEB ADMIN Index 34 ---
		String requestProt0034 = "https";
		String requestHost0034 = "preprod-teck.isometrix.net";
		int    requestPort0034 = 443;
		String requestFile0034 = "/scripts/semantic/transition.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0034 = Lib.replaceTextPattern(requestFile0034, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0034 = "GET " + requestFile0034 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0034, requestHost0034, requestPort0034, requestHeader0034, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0034 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [35] <- WEB ADMIN Index 35 ---
		String requestProt0035 = "https";
		String requestHost0035 = "preprod-teck.isometrix.net";
		int    requestPort0035 = 443;
		String requestFile0035 = "/scripts/semantic/visibility.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0035 = Lib.replaceTextPattern(requestFile0035, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0035 = "GET " + requestFile0035 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0035, requestHost0035, requestPort0035, requestHeader0035, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0035 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [36] <- WEB ADMIN Index 36 ---
		String requestProt0036 = "https";
		String requestHost0036 = "preprod-teck.isometrix.net";
		int    requestPort0036 = 443;
		String requestFile0036 = "/scripts/page.mixedmode.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0036 = Lib.replaceTextPattern(requestFile0036, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0036 = "GET " + requestFile0036 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0036, requestHost0036, requestPort0036, requestHeader0036, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0036 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [37] <- WEB ADMIN Index 37 ---
		String requestProt0037 = "https";
		String requestHost0037 = "preprod-teck.isometrix.net";
		int    requestPort0037 = 443;
		String requestFile0037 = "/scripts/kendo/kendo.web.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0037 = Lib.replaceTextPattern(requestFile0037, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0037 = "GET " + requestFile0037 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0037, requestHost0037, requestPort0037, requestHeader0037, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0037 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [38] <- WEB ADMIN Index 38 ---
		String requestProt0038 = "https";
		String requestHost0038 = "preprod-teck.isometrix.net";
		int    requestPort0038 = 443;
		String requestFile0038 = "/scripts/libs/handlebars.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0038 = Lib.replaceTextPattern(requestFile0038, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0038 = "GET " + requestFile0038 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0038, requestHost0038, requestPort0038, requestHeader0038, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0038 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [39] <- WEB ADMIN Index 39 ---
		String requestProt0039 = "https";
		String requestHost0039 = "preprod-teck.isometrix.net";
		int    requestPort0039 = 443;
		String requestFile0039 = "/scripts/core.tipsy.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0039 = Lib.replaceTextPattern(requestFile0039, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0039 = "GET " + requestFile0039 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0039, requestHost0039, requestPort0039, requestHeader0039, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0039 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [40] <- WEB ADMIN Index 40 ---
		String requestProt0040 = "https";
		String requestHost0040 = "preprod-teck.isometrix.net";
		int    requestPort0040 = 443;
		String requestFile0040 = "/scripts/core.select3.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0040 = Lib.replaceTextPattern(requestFile0040, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0040 = "GET " + requestFile0040 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0040, requestHost0040, requestPort0040, requestHeader0040, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0040 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #1_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #1_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_1_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #1 (fragment 3 of 3)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [41] <- WEB ADMIN Index 41 ---
		String requestProt0041 = "https";
		String requestHost0041 = "preprod-teck.isometrix.net";
		int    requestPort0041 = 443;
		String requestFile0041 = "/scripts/core.jstree.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0041 = Lib.replaceTextPattern(requestFile0041, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0041 = "GET " + requestFile0041 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0041, requestHost0041, requestPort0041, requestHeader0041, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0041 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [42] <- WEB ADMIN Index 42 ---
		String requestProt0042 = "https";
		String requestHost0042 = "preprod-teck.isometrix.net";
		int    requestPort0042 = 443;
		String requestFile0042 = "/scripts/core.jstree.select3.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0042 = Lib.replaceTextPattern(requestFile0042, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0042 = "GET " + requestFile0042 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0042, requestHost0042, requestPort0042, requestHeader0042, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0042 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [43] <- WEB ADMIN Index 43 ---
		String requestProt0043 = "https";
		String requestHost0043 = "preprod-teck.isometrix.net";
		int    requestPort0043 = 443;
		String requestFile0043 = "/scripts/core.popup.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0043 = Lib.replaceTextPattern(requestFile0043, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0043 = "GET " + requestFile0043 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0043, requestHost0043, requestPort0043, requestHeader0043, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0043 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [44] <- WEB ADMIN Index 44 ---
		String requestProt0044 = "https";
		String requestHost0044 = "preprod-teck.isometrix.net";
		int    requestPort0044 = 443;
		String requestFile0044 = "/scripts/core.constants.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0044 = Lib.replaceTextPattern(requestFile0044, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0044 = "GET " + requestFile0044 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0044, requestHost0044, requestPort0044, requestHeader0044, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0044 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [45] <- WEB ADMIN Index 45 ---
		String requestProt0045 = "https";
		String requestHost0045 = "preprod-teck.isometrix.net";
		int    requestPort0045 = 443;
		String requestFile0045 = "/css/themes/isometrix/assets/fonts/icomoon.woff2";
		String requestHeader0045 = "GET " + requestFile0045 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0045, requestHost0045, requestPort0045, requestHeader0045, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0045 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [46] <- WEB ADMIN Index 46 ---
		String requestProt0046 = "https";
		String requestHost0046 = "preprod-teck.isometrix.net";
		int    requestPort0046 = 443;
		String requestFile0046 = "/favicon.ico" +
				"?v=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0046 = Lib.replaceTextPattern(requestFile0046, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0046 = "GET " + requestFile0046 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0046, requestHost0046, requestPort0046, requestHeader0046, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0046 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [47] <- WEB ADMIN Index 47 ---
		String requestProt0047 = "https";
		String requestHost0047 = "preprod-teck.isometrix.net";
		int    requestPort0047 = 443;
		String requestFile0047 = "/scripts/core.jstree.main.overrides.js";
		String requestHeader0047 = "GET " + requestFile0047 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0047, requestHost0047, requestPort0047, requestHeader0047, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0047 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [48] <- WEB ADMIN Index 48 ---
		String requestProt0048 = "https";
		String requestHost0048 = "preprod-teck.isometrix.net";
		int    requestPort0048 = 443;
		String requestFile0048 = "/images/checkbox/chk.png";
		String requestHeader0048 = "GET " + requestFile0048 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0048, requestHost0048, requestPort0048, requestHeader0048, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0048 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #1_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #2: IsometrixSignInPage
		// # ----------------------------



		// --- HTTP REQUEST: Test [50] <- WEB ADMIN Index 50 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0050 = "https";
		String requestHost0050 = "preprod-teck.isometrix.net";
		int    requestPort0050 = 443;
		String requestFile0050 = "/login.aspx" +
				"?mixedmode=1";
		String requestHeader0050 = "GET " + requestFile0050 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0050, requestHost0050, requestPort0050, requestHeader0050, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0050 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 8791
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Company Name");		// Test [50] <- Index 50
		if(replayMode)
		{
			long proxyDataRecordId =1617042184266L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [51] <- WEB ADMIN Index 51 ---
		String requestProt0051 = "https";
		String requestHost0051 = "preprod-teck.isometrix.net";
		int    requestPort0051 = 443;
		String requestFile0051 = "/css/core.licence.popup.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0051 = Lib.replaceTextPattern(requestFile0051, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0051 = "GET " + requestFile0051 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0051, requestHost0051, requestPort0051, requestHeader0051, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0051 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [52] <- WEB ADMIN Index 52 ---
		String requestProt0052 = "https";
		String requestHost0052 = "preprod-teck.isometrix.net";
		int    requestPort0052 = 443;
		String requestFile0052 = "/css/semantic/message.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0052 = Lib.replaceTextPattern(requestFile0052, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0052 = "GET " + requestFile0052 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0052, requestHost0052, requestPort0052, requestHeader0052, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0052 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [53] <- WEB ADMIN Index 53 ---
		String requestProt0053 = "https";
		String requestHost0053 = "preprod-teck.isometrix.net";
		int    requestPort0053 = 443;
		String requestFile0053 = "/components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0053 = Lib.replaceTextPattern(requestFile0053, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0053 = "GET " + requestFile0053 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0053, requestHost0053, requestPort0053, requestHeader0053, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0053 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [54] <- WEB ADMIN Index 54 ---
		String requestProt0054 = "https";
		String requestHost0054 = "preprod-teck.isometrix.net";
		int    requestPort0054 = 443;
		String requestFile0054 = "/scripts/core.browser.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0054 = Lib.replaceTextPattern(requestFile0054, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0054 = "GET " + requestFile0054 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0054, requestHost0054, requestPort0054, requestHeader0054, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0054 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [55] <- WEB ADMIN Index 55 ---
		String requestProt0055 = "https";
		String requestHost0055 = "preprod-teck.isometrix.net";
		int    requestPort0055 = 443;
		String requestFile0055 = "/scripts/page.login.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0055 = Lib.replaceTextPattern(requestFile0055, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0055 = "GET " + requestFile0055 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0055, requestHost0055, requestPort0055, requestHeader0055, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0055 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [56] <- WEB ADMIN Index 56 ---
		String requestProt0056 = "https";
		String requestHost0056 = "preprod-teck.isometrix.net";
		int    requestPort0056 = 443;
		String requestFile0056 = "/scripts/core.licence.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0056 = Lib.replaceTextPattern(requestFile0056, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0056 = "GET " + requestFile0056 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0056, requestHost0056, requestPort0056, requestHeader0056, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0056 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [57] <- WEB ADMIN Index 57 ---
		String requestProt0057 = "https";
		String requestHost0057 = "preprod-teck.isometrix.net";
		int    requestPort0057 = 443;
		String requestFile0057 = "/scripts/core.moment.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0057 = Lib.replaceTextPattern(requestFile0057, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0057 = "GET " + requestFile0057 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0057, requestHost0057, requestPort0057, requestHeader0057, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0057 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [58] <- WEB ADMIN Index 58 ---
		String requestProt0058 = "https";
		String requestHost0058 = "preprod-teck.isometrix.net";
		int    requestPort0058 = 443;
		String requestFile0058 = "/images/layout/req.png";
		String requestHeader0058 = "GET " + requestFile0058 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0058, requestHost0058, requestPort0058, requestHeader0058, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0058 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [59] <- WEB ADMIN Index 59 ---
		String requestProt0059 = "https";
		String requestHost0059 = "preprod-teck.isometrix.net";
		int    requestPort0059 = 443;
		String requestFile0059 = "/images/layout/editable.png";
		String requestHeader0059 = "GET " + requestFile0059 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0059, requestHost0059, requestPort0059, requestHeader0059, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0059 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #3: Login
		// # --------------



		// --- HTTP REQUEST: Test [61] <- WEB ADMIN Index 61 ---
		String requestProt0061 = "https";
		String requestHost0061 = "preprod-teck.isometrix.net";
		int    requestPort0061 = 443;
		String requestFile0061 = "/login.aspx/submitLogin";
		String requestContent0061 = 
				"{ data: '{\"credentials\":{\"@username\":\"Auto.Tester1\",\"@password\":\"Teck2020#\",\"@login_as_request\":\"0\",\"@languageid\":\"A50A7F35-56F8-451E-82D9-946BD9ADEDB4\"}}' }";
		requestContent0061 = Lib.replaceTextPattern(requestContent0061, "Auto.Tester1", P_Username, 0);		// search and replace content fragment "Auto.Tester1" with variable 'P_Username' on all occurrences

		byte[] requestContentBinary0061 = requestContent0061.getBytes("UTF-8");
		String requestHeader0061 = "POST " + requestFile0061 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0061.length + "\r\n" + 		// Content-Length: 157
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0061, requestHost0061, requestPort0061, requestHeader0061, requestContentBinary0061, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0061 = null;		// support garbage collector to reduce memory
		requestContent0061 = null;		// support garbage collector to reduce memory
		requestContentBinary0061 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/XML", header text fragment = [verification disabled], recorded content size = 355
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/XML", null, "{\"status\":1,\"message\":\"login_success\",\"data\":\"{\\\"status\\\":");		// Test [61] <- Index 61
		if(replayMode)
		{
			long proxyDataRecordId =1617042201682L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [62] <- WEB ADMIN Index 62 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0062 = "https";
		String requestHost0062 = "preprod-teck.isometrix.net";
		int    requestPort0062 = 443;
		String requestFile0062 = "/default.aspx";
		String requestHeader0062 = "GET " + requestFile0062 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0062, requestHost0062, requestPort0062, requestHeader0062, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0062 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 6783
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Continue");		// Test [62] <- Index 62
		if(replayMode)
		{
			long proxyDataRecordId =1617042202275L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [63] <- WEB ADMIN Index 63 ---
		String requestProt0063 = "https";
		String requestHost0063 = "preprod-teck.isometrix.net";
		int    requestPort0063 = 443;
		String requestFile0063 = "//css/core.layout.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0063 = Lib.replaceTextPattern(requestFile0063, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0063 = "GET " + requestFile0063 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0063, requestHost0063, requestPort0063, requestHeader0063, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0063 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [64] <- WEB ADMIN Index 64 ---
		String requestProt0064 = "https";
		String requestHost0064 = "preprod-teck.isometrix.net";
		int    requestPort0064 = 443;
		String requestFile0064 = "//css/semantic/icon.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0064 = Lib.replaceTextPattern(requestFile0064, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0064 = "GET " + requestFile0064 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0064, requestHost0064, requestPort0064, requestHeader0064, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0064 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [65] <- WEB ADMIN Index 65 ---
		String requestProt0065 = "https";
		String requestHost0065 = "preprod-teck.isometrix.net";
		int    requestPort0065 = 443;
		String requestFile0065 = "//css/semantic/reset.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0065 = Lib.replaceTextPattern(requestFile0065, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0065 = "GET " + requestFile0065 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0065, requestHost0065, requestPort0065, requestHeader0065, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0065 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [66] <- WEB ADMIN Index 66 ---
		String requestProt0066 = "https";
		String requestHost0066 = "preprod-teck.isometrix.net";
		int    requestPort0066 = 443;
		String requestFile0066 = "//css/core.buttons.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0066 = Lib.replaceTextPattern(requestFile0066, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0066 = "GET " + requestFile0066 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0066, requestHost0066, requestPort0066, requestHeader0066, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0066 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [67] <- WEB ADMIN Index 67 ---
		String requestProt0067 = "https";
		String requestHost0067 = "preprod-teck.isometrix.net";
		int    requestPort0067 = 443;
		String requestFile0067 = "//css/semantic/site.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0067 = Lib.replaceTextPattern(requestFile0067, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0067 = "GET " + requestFile0067 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0067, requestHost0067, requestPort0067, requestHeader0067, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0067 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [68] <- WEB ADMIN Index 68 ---
		String requestProt0068 = "https";
		String requestHost0068 = "preprod-teck.isometrix.net";
		int    requestPort0068 = 443;
		String requestFile0068 = "//css/core.ui.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0068 = Lib.replaceTextPattern(requestFile0068, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0068 = "GET " + requestFile0068 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0068, requestHost0068, requestPort0068, requestHeader0068, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0068 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [69] <- WEB ADMIN Index 69 ---
		String requestProt0069 = "https";
		String requestHost0069 = "preprod-teck.isometrix.net";
		int    requestPort0069 = 443;
		String requestFile0069 = "//css/semantic/label.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0069 = Lib.replaceTextPattern(requestFile0069, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0069 = "GET " + requestFile0069 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0069, requestHost0069, requestPort0069, requestHeader0069, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0069 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [70] <- WEB ADMIN Index 70 ---
		String requestProt0070 = "https";
		String requestHost0070 = "preprod-teck.isometrix.net";
		int    requestPort0070 = 443;
		String requestFile0070 = "//css/semantic/dimmer.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0070 = Lib.replaceTextPattern(requestFile0070, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0070 = "GET " + requestFile0070 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0070, requestHost0070, requestPort0070, requestHeader0070, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0070 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [71] <- WEB ADMIN Index 71 ---
		String requestProt0071 = "https";
		String requestHost0071 = "preprod-teck.isometrix.net";
		int    requestPort0071 = 443;
		String requestFile0071 = "//css/semantic/loader.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0071 = Lib.replaceTextPattern(requestFile0071, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0071 = "GET " + requestFile0071 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0071, requestHost0071, requestPort0071, requestHeader0071, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0071 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [72] <- WEB ADMIN Index 72 ---
		String requestProt0072 = "https";
		String requestHost0072 = "preprod-teck.isometrix.net";
		int    requestPort0072 = 443;
		String requestFile0072 = "//css/core.icons.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0072 = Lib.replaceTextPattern(requestFile0072, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0072 = "GET " + requestFile0072 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0072, requestHost0072, requestPort0072, requestHeader0072, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0072 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [73] <- WEB ADMIN Index 73 ---
		String requestProt0073 = "https";
		String requestHost0073 = "preprod-teck.isometrix.net";
		int    requestPort0073 = 443;
		String requestFile0073 = "//css/semantic/transition.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0073 = Lib.replaceTextPattern(requestFile0073, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0073 = "GET " + requestFile0073 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0073, requestHost0073, requestPort0073, requestHeader0073, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0073 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [74] <- WEB ADMIN Index 74 ---
		String requestProt0074 = "https";
		String requestHost0074 = "preprod-teck.isometrix.net";
		int    requestPort0074 = 443;
		String requestFile0074 = "//css/semantic/message.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0074 = Lib.replaceTextPattern(requestFile0074, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0074 = "GET " + requestFile0074 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0074, requestHost0074, requestPort0074, requestHeader0074, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0074 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [75] <- WEB ADMIN Index 75 ---
		String requestProt0075 = "https";
		String requestHost0075 = "preprod-teck.isometrix.net";
		int    requestPort0075 = 443;
		String requestFile0075 = "//css/core.jstree.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0075 = Lib.replaceTextPattern(requestFile0075, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0075 = "GET " + requestFile0075 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0075, requestHost0075, requestPort0075, requestHeader0075, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0075 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [76] <- WEB ADMIN Index 76 ---
		String requestProt0076 = "https";
		String requestHost0076 = "preprod-teck.isometrix.net";
		int    requestPort0076 = 443;
		String requestFile0076 = "//css/core.jstree.overrides.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0076 = Lib.replaceTextPattern(requestFile0076, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0076 = "GET " + requestFile0076 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0076, requestHost0076, requestPort0076, requestHeader0076, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0076 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [77] <- WEB ADMIN Index 77 ---
		String requestProt0077 = "https";
		String requestHost0077 = "preprod-teck.isometrix.net";
		int    requestPort0077 = 443;
		String requestFile0077 = "//css/core.select3.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0077 = Lib.replaceTextPattern(requestFile0077, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0077 = "GET " + requestFile0077 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0077, requestHost0077, requestPort0077, requestHeader0077, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0077 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [78] <- WEB ADMIN Index 78 ---
		String requestProt0078 = "https";
		String requestHost0078 = "preprod-teck.isometrix.net";
		int    requestPort0078 = 443;
		String requestFile0078 = "//scripts/core.head.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0078 = Lib.replaceTextPattern(requestFile0078, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0078 = "GET " + requestFile0078 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0078, requestHost0078, requestPort0078, requestHeader0078, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0078 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [79] <- WEB ADMIN Index 79 ---
		String requestProt0079 = "https";
		String requestHost0079 = "preprod-teck.isometrix.net";
		int    requestPort0079 = 443;
		String requestFile0079 = "//css/core.grid.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0079 = Lib.replaceTextPattern(requestFile0079, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0079 = "GET " + requestFile0079 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0079, requestHost0079, requestPort0079, requestHeader0079, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0079 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [80] <- WEB ADMIN Index 80 ---
		String requestProt0080 = "https";
		String requestHost0080 = "preprod-teck.isometrix.net";
		int    requestPort0080 = 443;
		String requestFile0080 = "//css/page.default.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0080 = Lib.replaceTextPattern(requestFile0080, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0080 = "GET " + requestFile0080 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0080, requestHost0080, requestPort0080, requestHeader0080, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0080 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 2 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [81] <- WEB ADMIN Index 81 ---
		String requestProt0081 = "https";
		String requestHost0081 = "preprod-teck.isometrix.net";
		int    requestPort0081 = 443;
		String requestFile0081 = "//css/semantic/sidebar.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0081 = Lib.replaceTextPattern(requestFile0081, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0081 = "GET " + requestFile0081 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0081, requestHost0081, requestPort0081, requestHeader0081, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0081 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [82] <- WEB ADMIN Index 82 ---
		String requestProt0082 = "https";
		String requestHost0082 = "preprod-teck.isometrix.net";
		int    requestPort0082 = 443;
		String requestFile0082 = "//css/ie9Fixes.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0082 = Lib.replaceTextPattern(requestFile0082, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0082 = "GET " + requestFile0082 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0082, requestHost0082, requestPort0082, requestHeader0082, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0082 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [83] <- WEB ADMIN Index 83 ---
		String requestProt0083 = "https";
		String requestHost0083 = "preprod-teck.isometrix.net";
		int    requestPort0083 = 443;
		String requestFile0083 = "//css/semantic/menu.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0083 = Lib.replaceTextPattern(requestFile0083, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0083 = "GET " + requestFile0083 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0083, requestHost0083, requestPort0083, requestHeader0083, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0083 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [84] <- WEB ADMIN Index 84 ---
		String requestProt0084 = "https";
		String requestHost0084 = "preprod-teck.isometrix.net";
		int    requestPort0084 = 443;
		String requestFile0084 = "//components/theme/templates/theme.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0084 = Lib.replaceTextPattern(requestFile0084, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0084 = "GET " + requestFile0084 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0084, requestHost0084, requestPort0084, requestHeader0084, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0084 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [85] <- WEB ADMIN Index 85 ---
		String requestProt0085 = "https";
		String requestHost0085 = "preprod-teck.isometrix.net";
		int    requestPort0085 = 443;
		String requestFile0085 = "//css/core.ibutton.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0085 = Lib.replaceTextPattern(requestFile0085, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0085 = "GET " + requestFile0085 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0085, requestHost0085, requestPort0085, requestHeader0085, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0085 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [86] <- WEB ADMIN Index 86 ---
		String requestProt0086 = "https";
		String requestHost0086 = "preprod-teck.isometrix.net";
		int    requestPort0086 = 443;
		String requestFile0086 = "//scripts/core.session.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0086 = Lib.replaceTextPattern(requestFile0086, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0086 = "GET " + requestFile0086 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0086, requestHost0086, requestPort0086, requestHeader0086, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0086 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [87] <- WEB ADMIN Index 87 ---
		String requestProt0087 = "https";
		String requestHost0087 = "preprod-teck.isometrix.net";
		int    requestPort0087 = 443;
		String requestFile0087 = "//scripts/core.namespace.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0087 = Lib.replaceTextPattern(requestFile0087, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0087 = "GET " + requestFile0087 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0087, requestHost0087, requestPort0087, requestHeader0087, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0087 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [88] <- WEB ADMIN Index 88 ---
		String requestProt0088 = "https";
		String requestHost0088 = "preprod-teck.isometrix.net";
		int    requestPort0088 = 443;
		String requestFile0088 = "//scripts/core.jquery.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0088 = Lib.replaceTextPattern(requestFile0088, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0088 = "GET " + requestFile0088 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0088, requestHost0088, requestPort0088, requestHeader0088, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0088 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [89] <- WEB ADMIN Index 89 ---
		String requestProt0089 = "https";
		String requestHost0089 = "preprod-teck.isometrix.net";
		int    requestPort0089 = 443;
		String requestFile0089 = "//scripts/core.lodash.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0089 = Lib.replaceTextPattern(requestFile0089, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0089 = "GET " + requestFile0089 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0089, requestHost0089, requestPort0089, requestHeader0089, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0089 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [90] <- WEB ADMIN Index 90 ---
		String requestProt0090 = "https";
		String requestHost0090 = "preprod-teck.isometrix.net";
		int    requestPort0090 = 443;
		String requestFile0090 = "//scripts/core.utilities.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0090 = Lib.replaceTextPattern(requestFile0090, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0090 = "GET " + requestFile0090 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0090, requestHost0090, requestPort0090, requestHeader0090, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0090 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [91] <- WEB ADMIN Index 91 ---
		String requestProt0091 = "https";
		String requestHost0091 = "preprod-teck.isometrix.net";
		int    requestPort0091 = 443;
		String requestFile0091 = "//scripts/core.debug.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0091 = Lib.replaceTextPattern(requestFile0091, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0091 = "GET " + requestFile0091 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0091, requestHost0091, requestPort0091, requestHeader0091, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0091 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [92] <- WEB ADMIN Index 92 ---
		String requestProt0092 = "https";
		String requestHost0092 = "preprod-teck.isometrix.net";
		int    requestPort0092 = 443;
		String requestFile0092 = "//scripts/core.common.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0092 = Lib.replaceTextPattern(requestFile0092, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0092 = "GET " + requestFile0092 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0092, requestHost0092, requestPort0092, requestHeader0092, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0092 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [93] <- WEB ADMIN Index 93 ---
		String requestProt0093 = "https";
		String requestHost0093 = "preprod-teck.isometrix.net";
		int    requestPort0093 = 443;
		String requestFile0093 = "//scripts/core.ui.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0093 = Lib.replaceTextPattern(requestFile0093, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0093 = "GET " + requestFile0093 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0093, requestHost0093, requestPort0093, requestHeader0093, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0093 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [94] <- WEB ADMIN Index 94 ---
		String requestProt0094 = "https";
		String requestHost0094 = "preprod-teck.isometrix.net";
		int    requestPort0094 = 443;
		String requestFile0094 = "//scripts/core.ajax.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0094 = Lib.replaceTextPattern(requestFile0094, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0094 = "GET " + requestFile0094 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0094, requestHost0094, requestPort0094, requestHeader0094, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0094 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [95] <- WEB ADMIN Index 95 ---
		String requestProt0095 = "https";
		String requestHost0095 = "preprod-teck.isometrix.net";
		int    requestPort0095 = 443;
		String requestFile0095 = "//scripts/core.browser.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0095 = Lib.replaceTextPattern(requestFile0095, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0095 = "GET " + requestFile0095 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0095, requestHost0095, requestPort0095, requestHeader0095, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0095 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [96] <- WEB ADMIN Index 96 ---
		String requestProt0096 = "https";
		String requestHost0096 = "preprod-teck.isometrix.net";
		int    requestPort0096 = 443;
		String requestFile0096 = "//scripts/core.lang.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0096 = Lib.replaceTextPattern(requestFile0096, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0096 = "GET " + requestFile0096 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0096, requestHost0096, requestPort0096, requestHeader0096, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0096 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [97] <- WEB ADMIN Index 97 ---
		String requestProt0097 = "https";
		String requestHost0097 = "preprod-teck.isometrix.net";
		int    requestPort0097 = 443;
		String requestFile0097 = "//components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0097 = Lib.replaceTextPattern(requestFile0097, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0097 = "GET " + requestFile0097 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0097, requestHost0097, requestPort0097, requestHeader0097, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0097 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [98] <- WEB ADMIN Index 98 ---
		String requestProt0098 = "https";
		String requestHost0098 = "preprod-teck.isometrix.net";
		int    requestPort0098 = 443;
		String requestFile0098 = "//scripts/semantic/dimmer.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0098 = Lib.replaceTextPattern(requestFile0098, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0098 = "GET " + requestFile0098 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0098, requestHost0098, requestPort0098, requestHeader0098, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0098 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [99] <- WEB ADMIN Index 99 ---
		String requestProt0099 = "https";
		String requestHost0099 = "preprod-teck.isometrix.net";
		int    requestPort0099 = 443;
		String requestFile0099 = "//scripts/core.jqueryui.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0099 = Lib.replaceTextPattern(requestFile0099, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0099 = "GET " + requestFile0099 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0099, requestHost0099, requestPort0099, requestHeader0099, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0099 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [100] <- WEB ADMIN Index 100 ---
		String requestProt0100 = "https";
		String requestHost0100 = "preprod-teck.isometrix.net";
		int    requestPort0100 = 443;
		String requestFile0100 = "//scripts/semantic/transition.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0100 = Lib.replaceTextPattern(requestFile0100, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0100 = "GET " + requestFile0100 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0100, requestHost0100, requestPort0100, requestHeader0100, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0100 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #3_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_2.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 3 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [101] <- WEB ADMIN Index 101 ---
		String requestProt0101 = "https";
		String requestHost0101 = "preprod-teck.isometrix.net";
		int    requestPort0101 = 443;
		String requestFile0101 = "//scripts/semantic/visibility.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0101 = Lib.replaceTextPattern(requestFile0101, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0101 = "GET " + requestFile0101 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0101, requestHost0101, requestPort0101, requestHeader0101, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0101 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [102] <- WEB ADMIN Index 102 ---
		String requestProt0102 = "https";
		String requestHost0102 = "preprod-teck.isometrix.net";
		int    requestPort0102 = 443;
		String requestFile0102 = "//scripts/core.jstree.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0102 = Lib.replaceTextPattern(requestFile0102, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0102 = "GET " + requestFile0102 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0102, requestHost0102, requestPort0102, requestHeader0102, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0102 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [103] <- WEB ADMIN Index 103 ---
		String requestProt0103 = "https";
		String requestHost0103 = "preprod-teck.isometrix.net";
		int    requestPort0103 = 443;
		String requestFile0103 = "//scripts/core.constants.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0103 = Lib.replaceTextPattern(requestFile0103, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0103 = "GET " + requestFile0103 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0103, requestHost0103, requestPort0103, requestHeader0103, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0103 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [104] <- WEB ADMIN Index 104 ---
		String requestProt0104 = "https";
		String requestHost0104 = "preprod-teck.isometrix.net";
		int    requestPort0104 = 443;
		String requestFile0104 = "//scripts/core.tipsy.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0104 = Lib.replaceTextPattern(requestFile0104, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0104 = "GET " + requestFile0104 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0104, requestHost0104, requestPort0104, requestHeader0104, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0104 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [105] <- WEB ADMIN Index 105 ---
		String requestProt0105 = "https";
		String requestHost0105 = "preprod-teck.isometrix.net";
		int    requestPort0105 = 443;
		String requestFile0105 = "//scripts/core.interface.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0105 = Lib.replaceTextPattern(requestFile0105, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0105 = "GET " + requestFile0105 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0105, requestHost0105, requestPort0105, requestHeader0105, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0105 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [106] <- WEB ADMIN Index 106 ---
		String requestProt0106 = "https";
		String requestHost0106 = "preprod-teck.isometrix.net";
		int    requestPort0106 = 443;
		String requestFile0106 = "//scripts/core.ibutton.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0106 = Lib.replaceTextPattern(requestFile0106, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0106 = "GET " + requestFile0106 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0106, requestHost0106, requestPort0106, requestHeader0106, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0106 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [107] <- WEB ADMIN Index 107 ---
		String requestProt0107 = "https";
		String requestHost0107 = "preprod-teck.isometrix.net";
		int    requestPort0107 = 443;
		String requestFile0107 = "//scripts/core.ie.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0107 = Lib.replaceTextPattern(requestFile0107, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0107 = "GET " + requestFile0107 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0107, requestHost0107, requestPort0107, requestHeader0107, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0107 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [108] <- WEB ADMIN Index 108 ---
		String requestProt0108 = "https";
		String requestHost0108 = "preprod-teck.isometrix.net";
		int    requestPort0108 = 443;
		String requestFile0108 = "//scripts/libs/handlebars.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0108 = Lib.replaceTextPattern(requestFile0108, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0108 = "GET " + requestFile0108 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0108, requestHost0108, requestPort0108, requestHeader0108, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0108 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [109] <- WEB ADMIN Index 109 ---
		String requestProt0109 = "https";
		String requestHost0109 = "preprod-teck.isometrix.net";
		int    requestPort0109 = 443;
		String requestFile0109 = "//scripts/core.menu.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0109 = Lib.replaceTextPattern(requestFile0109, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0109 = "GET " + requestFile0109 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0109, requestHost0109, requestPort0109, requestHeader0109, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0109 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [110] <- WEB ADMIN Index 110 ---
		String requestProt0110 = "https";
		String requestHost0110 = "preprod-teck.isometrix.net";
		int    requestPort0110 = 443;
		String requestFile0110 = "//scripts/semantic/dropdown.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0110 = Lib.replaceTextPattern(requestFile0110, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0110 = "GET " + requestFile0110 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0110, requestHost0110, requestPort0110, requestHeader0110, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0110 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [111] <- WEB ADMIN Index 111 ---
		String requestProt0111 = "https";
		String requestHost0111 = "preprod-teck.isometrix.net";
		int    requestPort0111 = 443;
		String requestFile0111 = "//scripts/page.default.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0111 = Lib.replaceTextPattern(requestFile0111, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0111 = "GET " + requestFile0111 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0111, requestHost0111, requestPort0111, requestHeader0111, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0111 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [112] <- WEB ADMIN Index 112 ---
		String requestProt0112 = "https";
		String requestHost0112 = "preprod-teck.isometrix.net";
		int    requestPort0112 = 443;
		String requestFile0112 = "//scripts/core.sidebar.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0112 = Lib.replaceTextPattern(requestFile0112, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0112 = "GET " + requestFile0112 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0112, requestHost0112, requestPort0112, requestHeader0112, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0112 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [113] <- WEB ADMIN Index 113 ---
		String requestProt0113 = "https";
		String requestHost0113 = "preprod-teck.isometrix.net";
		int    requestPort0113 = 443;
		String requestFile0113 = "//scripts/core.globalsearch.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0113 = Lib.replaceTextPattern(requestFile0113, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0113 = "GET " + requestFile0113 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0113, requestHost0113, requestPort0113, requestHeader0113, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0113 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [114] <- WEB ADMIN Index 114 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0114 = "https";
		String requestHost0114 = "preprod-teck.isometrix.net";
		int    requestPort0114 = 443;
		String requestFile0114 = "//components/interfaces/interfaceMain.aspx";
		String requestHeader0114 = "GET " + requestFile0114 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0114, requestHost0114, requestPort0114, requestHeader0114, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0114 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [115] <- WEB ADMIN Index 115 ---
		String requestProt0115 = "https";
		String requestHost0115 = "preprod-teck.isometrix.net";
		int    requestPort0115 = 443;
		String requestFile0115 = "//css/themes/isometrix/assets/fonts/icomoon.woff2";
		String requestHeader0115 = "GET " + requestFile0115 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: identity\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0115, requestHost0115, requestPort0115, requestHeader0115, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0115 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [116] <- WEB ADMIN Index 116 ---
		String requestProt0116 = "https";
		String requestHost0116 = "preprod-teck.isometrix.net";
		int    requestPort0116 = 443;
		String requestFile0116 = "//css/themes/isometrix/assets/images/Logo.svg";
		String requestHeader0116 = "GET " + requestFile0116 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0116, requestHost0116, requestPort0116, requestHeader0116, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0116 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/SVG+XML", header text fragment = [verification disabled], recorded content size = 2638
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/SVG+XML", null, null);		// Test [116] <- Index 116
		if(replayMode)
		{
			long proxyDataRecordId =1617042205531L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [117] <- WEB ADMIN Index 117 ---
		log();
		log("# title: ");
		String requestProt0117 = "https";
		String requestHost0117 = "preprod-teck.isometrix.net";
		int    requestPort0117 = 443;
		String requestFile0117 = "//components/interfaces/qlikSense/qlikSenseApp.aspx";
		String requestHeader0117 = "GET " + requestFile0117 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0117, requestHost0117, requestPort0117, requestHeader0117, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0117 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [118] <- WEB ADMIN Index 118 ---
		String requestProt0118 = "https";
		String requestHost0118 = "preprod-teck.isometrix.net";
		int    requestPort0118 = 443;
		String requestFile0118 = "//favicon.ico" +
				"?v=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0118 = Lib.replaceTextPattern(requestFile0118, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0118 = "GET " + requestFile0118 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0118, requestHost0118, requestPort0118, requestHeader0118, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0118 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [119] <- WEB ADMIN Index 119 ---
		String requestProt0119 = "https";
		String requestHost0119 = "preprod-teck.isometrix.net";
		int    requestPort0119 = 443;
		String requestFile0119 = "//css/core.navbar.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0119 = Lib.replaceTextPattern(requestFile0119, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0119 = "GET " + requestFile0119 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0119, requestHost0119, requestPort0119, requestHeader0119, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0119 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [120] <- WEB ADMIN Index 120 ---
		String requestProt0120 = "https";
		String requestHost0120 = "preprod-teck.isometrix.net";
		int    requestPort0120 = 443;
		String requestFile0120 = "//css/core.actionbar.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0120 = Lib.replaceTextPattern(requestFile0120, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0120 = "GET " + requestFile0120 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0120, requestHost0120, requestPort0120, requestHeader0120, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0120 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #3_2 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_3.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 4 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [121] <- WEB ADMIN Index 121 ---
		String requestProt0121 = "https";
		String requestHost0121 = "preprod-teck.isometrix.net";
		int    requestPort0121 = 443;
		String requestFile0121 = "//css/core.screensize.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0121 = Lib.replaceTextPattern(requestFile0121, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0121 = "GET " + requestFile0121 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0121, requestHost0121, requestPort0121, requestHeader0121, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0121 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [122] <- WEB ADMIN Index 122 ---
		String requestProt0122 = "https";
		String requestHost0122 = "preprod-teck.isometrix.net";
		int    requestPort0122 = 443;
		String requestFile0122 = "//components/interfaces/css/jquery-ui.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0122 = Lib.replaceTextPattern(requestFile0122, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0122 = "GET " + requestFile0122 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0122, requestHost0122, requestPort0122, requestHeader0122, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0122 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [123] <- WEB ADMIN Index 123 ---
		String requestProt0123 = "https";
		String requestHost0123 = "preprod-teck.isometrix.net";
		int    requestPort0123 = 443;
		String requestFile0123 = "//css/ckeditor/theme/css/ckeditor.isometrix.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0123 = Lib.replaceTextPattern(requestFile0123, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0123 = "GET " + requestFile0123 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0123, requestHost0123, requestPort0123, requestHeader0123, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0123 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [124] <- WEB ADMIN Index 124 ---
		String requestProt0124 = "https";
		String requestHost0124 = "preprod-teck.isometrix.net";
		int    requestPort0124 = 443;
		String requestFile0124 = "//css/core.timeentry.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0124 = Lib.replaceTextPattern(requestFile0124, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0124 = "GET " + requestFile0124 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0124, requestHost0124, requestPort0124, requestHeader0124, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0124 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [125] <- WEB ADMIN Index 125 ---
		String requestProt0125 = "https";
		String requestHost0125 = "preprod-teck.isometrix.net";
		int    requestPort0125 = 443;
		String requestFile0125 = "//css/kendo/kendo.common.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0125 = Lib.replaceTextPattern(requestFile0125, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0125 = "GET " + requestFile0125 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0125, requestHost0125, requestPort0125, requestHeader0125, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0125 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [126] <- WEB ADMIN Index 126 ---
		String requestProt0126 = "https";
		String requestHost0126 = "preprod-teck.isometrix.net";
		int    requestPort0126 = 443;
		String requestFile0126 = "//css/kendo/kendo.material.min.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0126 = Lib.replaceTextPattern(requestFile0126, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0126 = "GET " + requestFile0126 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0126, requestHost0126, requestPort0126, requestHeader0126, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0126 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [127] <- WEB ADMIN Index 127 ---
		String requestProt0127 = "https";
		String requestHost0127 = "preprod-teck.isometrix.net";
		int    requestPort0127 = 443;
		String requestFile0127 = "//css/kendo/kendo.custom.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0127 = Lib.replaceTextPattern(requestFile0127, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0127 = "GET " + requestFile0127 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0127, requestHost0127, requestPort0127, requestHeader0127, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0127 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [128] <- WEB ADMIN Index 128 ---
		String requestProt0128 = "https";
		String requestHost0128 = "preprod-teck.isometrix.net";
		int    requestPort0128 = 443;
		String requestFile0128 = "//css/core.icheck.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0128 = Lib.replaceTextPattern(requestFile0128, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0128 = "GET " + requestFile0128 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0128, requestHost0128, requestPort0128, requestHeader0128, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0128 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [129] <- WEB ADMIN Index 129 ---
		String requestProt0129 = "https";
		String requestHost0129 = "preprod-teck.isometrix.net";
		int    requestPort0129 = 443;
		String requestFile0129 = "//components/interfaces/css/core.interface.main.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0129 = Lib.replaceTextPattern(requestFile0129, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0129 = "GET " + requestFile0129 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0129, requestHost0129, requestPort0129, requestHeader0129, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0129 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [130] <- WEB ADMIN Index 130 ---
		String requestProt0130 = "https";
		String requestHost0130 = "preprod-teck.isometrix.net";
		int    requestPort0130 = 443;
		String requestFile0130 = "//components/interfaces/qlikSense/qlikSenseApp.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0130 = Lib.replaceTextPattern(requestFile0130, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0130 = "GET " + requestFile0130 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0130, requestHost0130, requestPort0130, requestHeader0130, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0130 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [131] <- WEB ADMIN Index 131 ---
		String requestProt0131 = "https";
		String requestHost0131 = "preprod-teck.isometrix.net";
		int    requestPort0131 = 443;
		String requestFile0131 = "//scripts/core.navbar.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0131 = Lib.replaceTextPattern(requestFile0131, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0131 = "GET " + requestFile0131 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0131, requestHost0131, requestPort0131, requestHeader0131, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0131 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [132] <- WEB ADMIN Index 132 ---
		String requestProt0132 = "https";
		String requestHost0132 = "preprod-teck.isometrix.net";
		int    requestPort0132 = 443;
		String requestFile0132 = "//scripts/core.actionbar.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0132 = Lib.replaceTextPattern(requestFile0132, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0132 = "GET " + requestFile0132 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0132, requestHost0132, requestPort0132, requestHeader0132, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0132 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [133] <- WEB ADMIN Index 133 ---
		String requestProt0133 = "https";
		String requestHost0133 = "preprod-teck.isometrix.net";
		int    requestPort0133 = 443;
		String requestFile0133 = "//scripts/ckeditor/ckeditor.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0133 = Lib.replaceTextPattern(requestFile0133, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0133 = "GET " + requestFile0133 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0133, requestHost0133, requestPort0133, requestHeader0133, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0133 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [134] <- WEB ADMIN Index 134 ---
		String requestProt0134 = "https";
		String requestHost0134 = "preprod-teck.isometrix.net";
		int    requestPort0134 = 443;
		String requestFile0134 = "//scripts/kendo/kendo.web.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0134 = Lib.replaceTextPattern(requestFile0134, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0134 = "GET " + requestFile0134 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0134, requestHost0134, requestPort0134, requestHeader0134, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0134 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [135] <- WEB ADMIN Index 135 ---
		String requestProt0135 = "https";
		String requestHost0135 = "preprod-teck.isometrix.net";
		int    requestPort0135 = 443;
		String requestFile0135 = "//scripts/core.select3.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0135 = Lib.replaceTextPattern(requestFile0135, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0135 = "GET " + requestFile0135 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0135, requestHost0135, requestPort0135, requestHeader0135, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0135 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [136] <- WEB ADMIN Index 136 ---
		String requestProt0136 = "https";
		String requestHost0136 = "preprod-teck.isometrix.net";
		int    requestPort0136 = 443;
		String requestFile0136 = "//scripts/core.jstree.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0136 = Lib.replaceTextPattern(requestFile0136, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0136 = "GET " + requestFile0136 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0136, requestHost0136, requestPort0136, requestHeader0136, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0136 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [137] <- WEB ADMIN Index 137 ---
		String requestProt0137 = "https";
		String requestHost0137 = "preprod-teck.isometrix.net";
		int    requestPort0137 = 443;
		String requestFile0137 = "//scripts/core.jstree.select3.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0137 = Lib.replaceTextPattern(requestFile0137, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0137 = "GET " + requestFile0137 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0137, requestHost0137, requestPort0137, requestHeader0137, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0137 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [138] <- WEB ADMIN Index 138 ---
		String requestProt0138 = "https";
		String requestHost0138 = "preprod-teck.isometrix.net";
		int    requestPort0138 = 443;
		String requestFile0138 = "//scripts/core.dragscroll.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0138 = Lib.replaceTextPattern(requestFile0138, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0138 = "GET " + requestFile0138 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0138, requestHost0138, requestPort0138, requestHeader0138, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0138 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [139] <- WEB ADMIN Index 139 ---
		String requestProt0139 = "https";
		String requestHost0139 = "preprod-teck.isometrix.net";
		int    requestPort0139 = 443;
		String requestFile0139 = "//scripts/core.textbox.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0139 = Lib.replaceTextPattern(requestFile0139, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0139 = "GET " + requestFile0139 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0139, requestHost0139, requestPort0139, requestHeader0139, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0139 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [140] <- WEB ADMIN Index 140 ---
		String requestProt0140 = "https";
		String requestHost0140 = "preprod-teck.isometrix.net";
		int    requestPort0140 = 443;
		String requestFile0140 = "//scripts/core.moment.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0140 = Lib.replaceTextPattern(requestFile0140, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0140 = "GET " + requestFile0140 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0140, requestHost0140, requestPort0140, requestHeader0140, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0140 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #3_3 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #3_4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_3_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #3 (fragment 5 of 5)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [141] <- WEB ADMIN Index 141 ---
		String requestProt0141 = "https";
		String requestHost0141 = "preprod-teck.isometrix.net";
		int    requestPort0141 = 443;
		String requestFile0141 = "//scripts/core.screensize.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0141 = Lib.replaceTextPattern(requestFile0141, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0141 = "GET " + requestFile0141 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0141, requestHost0141, requestPort0141, requestHeader0141, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0141 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [142] <- WEB ADMIN Index 142 ---
		String requestProt0142 = "https";
		String requestHost0142 = "preprod-teck.isometrix.net";
		int    requestPort0142 = 443;
		String requestFile0142 = "//scripts/core.icheck.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0142 = Lib.replaceTextPattern(requestFile0142, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0142 = "GET " + requestFile0142 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0142, requestHost0142, requestPort0142, requestHeader0142, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0142 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [143] <- WEB ADMIN Index 143 ---
		String requestProt0143 = "https";
		String requestHost0143 = "preprod-teck.isometrix.net";
		int    requestPort0143 = 443;
		String requestFile0143 = "//components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0143 = Lib.replaceTextPattern(requestFile0143, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0143 = "GET " + requestFile0143 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0143, requestHost0143, requestPort0143, requestHeader0143, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0143 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [144] <- WEB ADMIN Index 144 ---
		String requestProt0144 = "https";
		String requestHost0144 = "preprod-teck.isometrix.net";
		int    requestPort0144 = 443;
		String requestFile0144 = "//scripts/libs/objectFitPolyfill.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0144 = Lib.replaceTextPattern(requestFile0144, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0144 = "GET " + requestFile0144 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0144, requestHost0144, requestPort0144, requestHeader0144, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0144 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [145] <- WEB ADMIN Index 145 ---
		String requestProt0145 = "https";
		String requestHost0145 = "preprod-teck.isometrix.net";
		int    requestPort0145 = 443;
		String requestFile0145 = "//scripts/core.plugin.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0145 = Lib.replaceTextPattern(requestFile0145, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0145 = "GET " + requestFile0145 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0145, requestHost0145, requestPort0145, requestHeader0145, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0145 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [146] <- WEB ADMIN Index 146 ---
		String requestProt0146 = "https";
		String requestHost0146 = "preprod-teck.isometrix.net";
		int    requestPort0146 = 443;
		String requestFile0146 = "//scripts/core.timeentry.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0146 = Lib.replaceTextPattern(requestFile0146, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0146 = "GET " + requestFile0146 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0146, requestHost0146, requestPort0146, requestHeader0146, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0146 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [147] <- WEB ADMIN Index 147 ---
		String requestProt0147 = "https";
		String requestHost0147 = "preprod-teck.isometrix.net";
		int    requestPort0147 = 443;
		String requestFile0147 = "//scripts/core.timeentry.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0147 = Lib.replaceTextPattern(requestFile0147, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0147 = "GET " + requestFile0147 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0147, requestHost0147, requestPort0147, requestHeader0147, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0147 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [148] <- WEB ADMIN Index 148 ---
		String requestProt0148 = "https";
		String requestHost0148 = "preprod-teck.isometrix.net";
		int    requestPort0148 = 443;
		String requestFile0148 = "//components/interfaces/scripts/page.interface.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0148 = Lib.replaceTextPattern(requestFile0148, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0148 = "GET " + requestFile0148 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0148, requestHost0148, requestPort0148, requestHeader0148, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0148 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [149] <- WEB ADMIN Index 149 ---
		String requestProt0149 = "https";
		String requestHost0149 = "preprod-teck.isometrix.net";
		int    requestPort0149 = 443;
		String requestFile0149 = "//scripts/core.jstree.main.overrides.js";
		String requestHeader0149 = "GET " + requestFile0149 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0149, requestHost0149, requestPort0149, requestHeader0149, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0149 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [150] <- WEB ADMIN Index 150 ---
		String requestProt0150 = "https";
		String requestHost0150 = "preprod-teck.isometrix.net";
		int    requestPort0150 = 443;
		String requestFile0150 = "//components/admin/common.aspx/DataUtil";
		String requestContent0150 = 
				"{ callType: 'Interfaces', call: 'LoadUserInterface', data: '{\"interfaceId\":\"1f996d65-c899-4c4b-a617-02b8a8d81868\",\"includeOwnInterface\":1}' }";
		byte[] requestContentBinary0150 = requestContent0150.getBytes("UTF-8");
		String requestHeader0150 = "POST " + requestFile0150 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0150.length + "\r\n" + 		// Content-Length: 141
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0150, requestHost0150, requestPort0150, requestHeader0150, requestContentBinary0150, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0150 = null;		// support garbage collector to reduce memory
		requestContent0150 = null;		// support garbage collector to reduce memory
		requestContentBinary0150 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 291
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get interface successful\",\"data\"");		// Test [150] <- Index 150
		if(replayMode)
		{
			long proxyDataRecordId =1617042210663L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [151] <- WEB ADMIN Index 151 ---
		String requestProt0151 = "https";
		String requestHost0151 = "preprod-teck.isometrix.net";
		int    requestPort0151 = 443;
		String requestFile0151 = "//components/admin/common.aspx/DataUtil";
		String requestContent0151 = 
				"{ callType: 'Settings', call: 'GetSystemPagePermissions', data: '{\"item\":{\"@systempageid\":\"D0C88EBA-9E93-4F37-81BE-43BED095AF67\"}}' }";
		byte[] requestContentBinary0151 = requestContent0151.getBytes("UTF-8");
		String requestHeader0151 = "POST " + requestFile0151 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0151.length + "\r\n" + 		// Content-Length: 133
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0151, requestHost0151, requestPort0151, requestHeader0151, requestContentBinary0151, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0151 = null;		// support garbage collector to reduce memory
		requestContent0151 = null;		// support garbage collector to reduce memory
		requestContentBinary0151 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 411
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, ",\"status\":1,\"message\":\"required_permissions");		// Test [151] <- Index 151
		if(replayMode)
		{
			long proxyDataRecordId =1617042210946L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [152] <- WEB ADMIN Index 152 ---
		String requestProt0152 = "https";
		String requestHost0152 = "preprod-teck.isometrix.net";
		int    requestPort0152 = 443;
		String requestFile0152 = "//components/admin/common.aspx/DataUtil";
		String requestContent0152 = 
				"{ callType: 'Interfaces', call: 'GetInterfaceList', data: '{\"includeOwnInterface\":\"2\"}' }";
		byte[] requestContentBinary0152 = requestContent0152.getBytes("UTF-8");
		String requestHeader0152 = "POST " + requestFile0152 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0152.length + "\r\n" + 		// Content-Length: 89
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0152, requestHost0152, requestPort0152, requestHeader0152, requestContentBinary0152, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0152 = null;		// support garbage collector to reduce memory
		requestContent0152 = null;		// support garbage collector to reduce memory
		requestContentBinary0152 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 283
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get interfaces items successful\",\"");		// Test [152] <- Index 152
		if(replayMode)
		{
			long proxyDataRecordId =1617042210962L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [153] <- WEB ADMIN Index 153 ---
		String requestProt0153 = "https";
		String requestHost0153 = "preprod-teck.isometrix.net";
		int    requestPort0153 = 443;
		String requestFile0153 = "//components/admin/common.aspx/DataUtil";
		String requestContent0153 = 
				"{ callType: 'Menu', call: 'GetMenu', data: '{\"item\":[{\"@id\":\"\",\"@languageid\":\"a50a7f35-56f8-451e-82d9-946bd9adedb4\",\"@name\":\"\",\"@matchtype\":\"\",\"@offset\":\"\",\"@limit\":\"\",\"@page\":\"\"}]}' }";
		byte[] requestContentBinary0153 = requestContent0153.getBytes("UTF-8");
		String requestHeader0153 = "POST " + requestFile0153 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0153.length + "\r\n" + 		// Content-Length: 184
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0153, requestHost0153, requestPort0153, requestHeader0153, requestContentBinary0153, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0153 = null;		// support garbage collector to reduce memory
		requestContent0153 = null;		// support garbage collector to reduce memory
		requestContentBinary0153 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 3766
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get menu successful");		// Test [153] <- Index 153
		if(replayMode)
		{
			long proxyDataRecordId =1617042210974L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [154] <- WEB ADMIN Index 154 ---
		String requestProt0154 = "https";
		String requestHost0154 = "preprod-teck.isometrix.net";
		int    requestPort0154 = 443;
		String requestFile0154 = "//components/admin/common.aspx/DataUtil";
		String requestContent0154 = 
				"{ callType: 'Settings', call: 'GetApplicationSettings', data: '{}' }";
		byte[] requestContentBinary0154 = requestContent0154.getBytes("UTF-8");
		String requestHeader0154 = "POST " + requestFile0154 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0154.length + "\r\n" + 		// Content-Length: 68
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0154, requestHost0154, requestPort0154, requestHeader0154, requestContentBinary0154, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0154 = null;		// support garbage collector to reduce memory
		requestContent0154 = null;		// support garbage collector to reduce memory
		requestContentBinary0154 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 60922
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"success\",\"data\":\"");		// Test [154] <- Index 154
		if(replayMode)
		{
			long proxyDataRecordId =1617042210983L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [155] <- WEB ADMIN Index 155 ---
		String requestProt0155 = "https";
		String requestHost0155 = "preprod-teck.isometrix.net";
		int    requestPort0155 = 443;
		String requestFile0155 = "//components/admin/common.aspx/DataUtil";
		String requestContent0155 = 
				"{ callType: 'Interfaces', call: 'LoadUserInterface', data: '{\"interfaceId\":\"75D16221-EB9E-4061-BD08-15869013A027\",\"includeOwnInterface\":1}' }";
		byte[] requestContentBinary0155 = requestContent0155.getBytes("UTF-8");
		String requestHeader0155 = "POST " + requestFile0155 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0155.length + "\r\n" + 		// Content-Length: 141
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0155, requestHost0155, requestPort0155, requestHeader0155, requestContentBinary0155, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0155 = null;		// support garbage collector to reduce memory
		requestContent0155 = null;		// support garbage collector to reduce memory
		requestContentBinary0155 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 291
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get interface successful\",\"data\"");		// Test [155] <- Index 155
		if(replayMode)
		{
			long proxyDataRecordId =1617042211101L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #3_4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #4.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #4: TeckStandardInterface
		// # ------------------------------



		// --- HTTP REQUEST: Test [157] <- WEB ADMIN Index 157 ---
		String requestProt0157 = "https";
		String requestHost0157 = "preprod-teck.isometrix.net";
		int    requestPort0157 = 443;
		String requestFile0157 = "//images/tooltip/tipsy.gif";
		String requestHeader0157 = "GET " + requestFile0157 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0157, requestHost0157, requestPort0157, requestHeader0157, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0157 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 64
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [157] <- Index 157
		if(replayMode)
		{
			long proxyDataRecordId =1617042228377L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [158] <- WEB ADMIN Index 158 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0158 = "https";
		String requestHost0158 = "preprod-teck.isometrix.net";
		int    requestPort0158 = 443;
		String requestFile0158 = "//components/interfaces/interfaceMain.aspx" +
				"?id=6e014e51-3f22-469a-828e-0b74d6d4ce0f";
		String requestHeader0158 = "GET " + requestFile0158 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0158, requestHost0158, requestPort0158, requestHeader0158, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0158 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 2006
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "IsoMetrix");		// Test [158] <- Index 158
		if(replayMode)
		{
			long proxyDataRecordId =1617042232396L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [159] <- WEB ADMIN Index 159 ---
		String requestProt0159 = "https";
		String requestHost0159 = "preprod-teck.isometrix.net";
		int    requestPort0159 = 443;
		String requestFile0159 = "//components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0159 = Lib.replaceTextPattern(requestFile0159, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0159 = "GET " + requestFile0159 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0159, requestHost0159, requestPort0159, requestHeader0159, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0159 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [160] <- WEB ADMIN Index 160 ---
		String requestProt0160 = "https";
		String requestHost0160 = "preprod-teck.isometrix.net";
		int    requestPort0160 = 443;
		String requestFile0160 = "//components/admin/common.aspx/DataUtil";
		String requestContent0160 = 
				"{ callType: 'Interfaces', call: 'LoadUserInterface', data: '{\"interfaceId\":\"6e014e51-3f22-469a-828e-0b74d6d4ce0f\",\"includeOwnInterface\":1}' }";
		byte[] requestContentBinary0160 = requestContent0160.getBytes("UTF-8");
		String requestHeader0160 = "POST " + requestFile0160 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0160.length + "\r\n" + 		// Content-Length: 141
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0160, requestHost0160, requestPort0160, requestHeader0160, requestContentBinary0160, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0160 = null;		// support garbage collector to reduce memory
		requestContent0160 = null;		// support garbage collector to reduce memory
		requestContentBinary0160 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 4625
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get interface successful\",\"data\"");		// Test [160] <- Index 160
		if(replayMode)
		{
			long proxyDataRecordId =1617042233298L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #4 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #5.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #5: Compliance
		// # -------------------



		// --- HTTP REQUEST: Test [162] <- WEB ADMIN Index 162 ---
		String requestProt0162 = "https";
		String requestHost0162 = "preprod-teck.isometrix.net";
		int    requestPort0162 = 443;
		String requestFile0162 = "//components/admin/common.aspx/DataUtil";
		String requestContent0162 = 
				"{ callType: 'Interfaces', call: 'LoadUserInterface', data: '{\"interfaceId\":\"9c153749-81cb-4463-91a1-d4ea1b379e2c\",\"includeOwnInterface\":1}' }";
		byte[] requestContentBinary0162 = requestContent0162.getBytes("UTF-8");
		String requestHeader0162 = "POST " + requestFile0162 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0162.length + "\r\n" + 		// Content-Length: 141
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0162, requestHost0162, requestPort0162, requestHeader0162, requestContentBinary0162, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0162 = null;		// support garbage collector to reduce memory
		requestContent0162 = null;		// support garbage collector to reduce memory
		requestContentBinary0162 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 5219
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"get interface successful\",\"data\"");		// Test [162] <- Index 162
		if(replayMode)
		{
			long proxyDataRecordId =1617042247997L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #5 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #6.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #6: ComplianceRegister
		// # ---------------------------



		// --- HTTP REQUEST: Test [164] <- WEB ADMIN Index 164 ---
		log();
		log("# title: IsoMetrix");
		String requestProt0164 = "https";
		String requestHost0164 = "preprod-teck.isometrix.net";
		int    requestPort0164 = 443;
		String requestFile0164 = "//components/viewer/module.aspx" +
				"?id=06a92b5e-4170-473c-b9f9-cff06ab14c74" +
				"&action=o";
		String requestHeader0164 = "GET " + requestFile0164 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0164, requestHost0164, requestPort0164, requestHeader0164, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0164 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 7856
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Obligation short description");		// Test [164] <- Index 164
		if(replayMode)
		{
			long proxyDataRecordId =1617042266923L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [165] <- WEB ADMIN Index 165 ---
		String requestProt0165 = "https";
		String requestHost0165 = "preprod-teck.isometrix.net";
		int    requestPort0165 = 443;
		String requestFile0165 = "//css/core.tabpanel.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0165 = Lib.replaceTextPattern(requestFile0165, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0165 = "GET " + requestFile0165 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0165, requestHost0165, requestPort0165, requestHeader0165, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0165 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [166] <- WEB ADMIN Index 166 ---
		String requestProt0166 = "https";
		String requestHost0166 = "preprod-teck.isometrix.net";
		int    requestPort0166 = 443;
		String requestFile0166 = "//css/core.opentip.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0166 = Lib.replaceTextPattern(requestFile0166, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0166 = "GET " + requestFile0166 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0166, requestHost0166, requestPort0166, requestHeader0166, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0166 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [167] <- WEB ADMIN Index 167 ---
		String requestProt0167 = "https";
		String requestHost0167 = "preprod-teck.isometrix.net";
		int    requestPort0167 = 443;
		String requestFile0167 = "//css/page.module.viewer.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0167 = Lib.replaceTextPattern(requestFile0167, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0167 = "GET " + requestFile0167 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0167, requestHost0167, requestPort0167, requestHeader0167, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0167 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [168] <- WEB ADMIN Index 168 ---
		String requestProt0168 = "https";
		String requestHost0168 = "preprod-teck.isometrix.net";
		int    requestPort0168 = 443;
		String requestFile0168 = "//css/core.mapbox.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0168 = Lib.replaceTextPattern(requestFile0168, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0168 = "GET " + requestFile0168 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0168, requestHost0168, requestPort0168, requestHeader0168, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0168 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [169] <- WEB ADMIN Index 169 ---
		String requestProt0169 = "https";
		String requestHost0169 = "preprod-teck.isometrix.net";
		int    requestPort0169 = 443;
		String requestFile0169 = "//css/core.linkbox.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0169 = Lib.replaceTextPattern(requestFile0169, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0169 = "GET " + requestFile0169 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0169, requestHost0169, requestPort0169, requestHeader0169, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0169 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [170] <- WEB ADMIN Index 170 ---
		String requestProt0170 = "https";
		String requestHost0170 = "preprod-teck.isometrix.net";
		int    requestPort0170 = 443;
		String requestFile0170 = "//css/core.imagecontrol.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0170 = Lib.replaceTextPattern(requestFile0170, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0170 = "GET " + requestFile0170 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0170, requestHost0170, requestPort0170, requestHeader0170, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0170 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [171] <- WEB ADMIN Index 171 ---
		String requestProt0171 = "https";
		String requestHost0171 = "preprod-teck.isometrix.net";
		int    requestPort0171 = 443;
		String requestFile0171 = "//css/core.textbox.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0171 = Lib.replaceTextPattern(requestFile0171, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0171 = "GET " + requestFile0171 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0171, requestHost0171, requestPort0171, requestHeader0171, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0171 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [172] <- WEB ADMIN Index 172 ---
		String requestProt0172 = "https";
		String requestHost0172 = "preprod-teck.isometrix.net";
		int    requestPort0172 = 443;
		String requestFile0172 = "//css/page.checklist.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0172 = Lib.replaceTextPattern(requestFile0172, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0172 = "GET " + requestFile0172 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0172, requestHost0172, requestPort0172, requestHeader0172, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0172 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [173] <- WEB ADMIN Index 173 ---
		String requestProt0173 = "https";
		String requestHost0173 = "preprod-teck.isometrix.net";
		int    requestPort0173 = 443;
		String requestFile0173 = "//css/core.panel.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0173 = Lib.replaceTextPattern(requestFile0173, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0173 = "GET " + requestFile0173 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0173, requestHost0173, requestPort0173, requestHeader0173, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0173 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [174] <- WEB ADMIN Index 174 ---
		String requestProt0174 = "https";
		String requestHost0174 = "preprod-teck.isometrix.net";
		int    requestPort0174 = 443;
		String requestFile0174 = "//css/core.sharepoint.css" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0174 = Lib.replaceTextPattern(requestFile0174, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0174 = "GET " + requestFile0174 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0174, requestHost0174, requestPort0174, requestHeader0174, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0174 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [175] <- WEB ADMIN Index 175 ---
		String requestProt0175 = "https";
		String requestHost0175 = "preprod-teck.isometrix.net";
		int    requestPort0175 = 443;
		String requestFile0175 = "//components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0175 = Lib.replaceTextPattern(requestFile0175, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0175 = "GET " + requestFile0175 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0175, requestHost0175, requestPort0175, requestHeader0175, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0175 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [176] <- WEB ADMIN Index 176 ---
		String requestProt0176 = "https";
		String requestHost0176 = "preprod-teck.isometrix.net";
		int    requestPort0176 = 443;
		String requestFile0176 = "//scripts/core.hoverintent.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0176 = Lib.replaceTextPattern(requestFile0176, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0176 = "GET " + requestFile0176 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0176, requestHost0176, requestPort0176, requestHeader0176, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0176 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [177] <- WEB ADMIN Index 177 ---
		String requestProt0177 = "https";
		String requestHost0177 = "preprod-teck.isometrix.net";
		int    requestPort0177 = 443;
		String requestFile0177 = "//scripts/core.popup.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0177 = Lib.replaceTextPattern(requestFile0177, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0177 = "GET " + requestFile0177 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0177, requestHost0177, requestPort0177, requestHeader0177, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0177 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [178] <- WEB ADMIN Index 178 ---
		String requestProt0178 = "https";
		String requestHost0178 = "preprod-teck.isometrix.net";
		int    requestPort0178 = 443;
		String requestFile0178 = "//scripts/core.mousewheel.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0178 = Lib.replaceTextPattern(requestFile0178, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0178 = "GET " + requestFile0178 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0178, requestHost0178, requestPort0178, requestHeader0178, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0178 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [179] <- WEB ADMIN Index 179 ---
		String requestProt0179 = "https";
		String requestHost0179 = "preprod-teck.isometrix.net";
		int    requestPort0179 = 443;
		String requestFile0179 = "//scripts/core.mapbox.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0179 = Lib.replaceTextPattern(requestFile0179, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0179 = "GET " + requestFile0179 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0179, requestHost0179, requestPort0179, requestHeader0179, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0179 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [180] <- WEB ADMIN Index 180 ---
		String requestProt0180 = "https";
		String requestHost0180 = "preprod-teck.isometrix.net";
		int    requestPort0180 = 443;
		String requestFile0180 = "//scripts/core.plupload.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0180 = Lib.replaceTextPattern(requestFile0180, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0180 = "GET " + requestFile0180 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0180, requestHost0180, requestPort0180, requestHeader0180, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0180 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [181] <- WEB ADMIN Index 181 ---
		String requestProt0181 = "https";
		String requestHost0181 = "preprod-teck.isometrix.net";
		int    requestPort0181 = 443;
		String requestFile0181 = "//scripts/core.linkbox.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0181 = Lib.replaceTextPattern(requestFile0181, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0181 = "GET " + requestFile0181 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0181, requestHost0181, requestPort0181, requestHeader0181, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0181 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [182] <- WEB ADMIN Index 182 ---
		String requestProt0182 = "https";
		String requestHost0182 = "preprod-teck.isometrix.net";
		int    requestPort0182 = 443;
		String requestFile0182 = "//scripts/core.imagecontrol.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0182 = Lib.replaceTextPattern(requestFile0182, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0182 = "GET " + requestFile0182 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0182, requestHost0182, requestPort0182, requestHeader0182, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0182 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [183] <- WEB ADMIN Index 183 ---
		String requestProt0183 = "https";
		String requestHost0183 = "preprod-teck.isometrix.net";
		int    requestPort0183 = 443;
		String requestFile0183 = "//scripts/core.tabpanel.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0183 = Lib.replaceTextPattern(requestFile0183, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0183 = "GET " + requestFile0183 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0183, requestHost0183, requestPort0183, requestHeader0183, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0183 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #6 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #6_1.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_6_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// ... continuing page #6 (fragment 2 of 2)
		// ----------------------------------------



		// --- HTTP REQUEST: Test [184] <- WEB ADMIN Index 184 ---
		String requestProt0184 = "https";
		String requestHost0184 = "preprod-teck.isometrix.net";
		int    requestPort0184 = 443;
		String requestFile0184 = "//scripts/core.translator.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0184 = Lib.replaceTextPattern(requestFile0184, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0184 = "GET " + requestFile0184 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0184, requestHost0184, requestPort0184, requestHeader0184, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0184 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [185] <- WEB ADMIN Index 185 ---
		String requestProt0185 = "https";
		String requestHost0185 = "preprod-teck.isometrix.net";
		int    requestPort0185 = 443;
		String requestFile0185 = "//scripts/core.fader.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0185 = Lib.replaceTextPattern(requestFile0185, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0185 = "GET " + requestFile0185 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0185, requestHost0185, requestPort0185, requestHeader0185, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0185 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [186] <- WEB ADMIN Index 186 ---
		String requestProt0186 = "https";
		String requestHost0186 = "preprod-teck.isometrix.net";
		int    requestPort0186 = 443;
		String requestFile0186 = "//scripts/core.panel.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0186 = Lib.replaceTextPattern(requestFile0186, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0186 = "GET " + requestFile0186 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0186, requestHost0186, requestPort0186, requestHeader0186, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0186 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [187] <- WEB ADMIN Index 187 ---
		String requestProt0187 = "https";
		String requestHost0187 = "preprod-teck.isometrix.net";
		int    requestPort0187 = 443;
		String requestFile0187 = "//scripts/core.opentip.adapter.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0187 = Lib.replaceTextPattern(requestFile0187, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0187 = "GET " + requestFile0187 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0187, requestHost0187, requestPort0187, requestHeader0187, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0187 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [188] <- WEB ADMIN Index 188 ---
		String requestProt0188 = "https";
		String requestHost0188 = "preprod-teck.isometrix.net";
		int    requestPort0188 = 443;
		String requestFile0188 = "//scripts/core.opentip.main.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0188 = Lib.replaceTextPattern(requestFile0188, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0188 = "GET " + requestFile0188 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0188, requestHost0188, requestPort0188, requestHeader0188, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0188 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [189] <- WEB ADMIN Index 189 ---
		String requestProt0189 = "https";
		String requestHost0189 = "preprod-teck.isometrix.net";
		int    requestPort0189 = 443;
		String requestFile0189 = "//scripts/core.formbrowser.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0189 = Lib.replaceTextPattern(requestFile0189, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0189 = "GET " + requestFile0189 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0189, requestHost0189, requestPort0189, requestHeader0189, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0189 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [190] <- WEB ADMIN Index 190 ---
		String requestProt0190 = "https";
		String requestHost0190 = "preprod-teck.isometrix.net";
		int    requestPort0190 = 443;
		String requestFile0190 = "//scripts/core.opentip.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0190 = Lib.replaceTextPattern(requestFile0190, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0190 = "GET " + requestFile0190 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0190, requestHost0190, requestPort0190, requestHeader0190, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0190 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [191] <- WEB ADMIN Index 191 ---
		String requestProt0191 = "https";
		String requestHost0191 = "preprod-teck.isometrix.net";
		int    requestPort0191 = 443;
		String requestFile0191 = "//scripts/core.sharepoint.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0191 = Lib.replaceTextPattern(requestFile0191, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0191 = "GET " + requestFile0191 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0191, requestHost0191, requestPort0191, requestHeader0191, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0191 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [192] <- WEB ADMIN Index 192 ---
		String requestProt0192 = "https";
		String requestHost0192 = "preprod-teck.isometrix.net";
		int    requestPort0192 = 443;
		String requestFile0192 = "//components/viewer/scripts/page.checklist.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0192 = Lib.replaceTextPattern(requestFile0192, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0192 = "GET " + requestFile0192 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0192, requestHost0192, requestPort0192, requestHeader0192, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0192 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [193] <- WEB ADMIN Index 193 ---
		String requestProt0193 = "https";
		String requestHost0193 = "preprod-teck.isometrix.net";
		int    requestPort0193 = 443;
		String requestFile0193 = "//components/viewer/scripts/page.module.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0193 = Lib.replaceTextPattern(requestFile0193, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0193 = "GET " + requestFile0193 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0193, requestHost0193, requestPort0193, requestHeader0193, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0193 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [194] <- WEB ADMIN Index 194 ---
		String requestProt0194 = "https";
		String requestHost0194 = "preprod-teck.isometrix.net";
		int    requestPort0194 = 443;
		String requestFile0194 = "//scripts/kendo/messages/kendo.messages.en-ZA.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0194 = Lib.replaceTextPattern(requestFile0194, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0194 = "GET " + requestFile0194 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0194, requestHost0194, requestPort0194, requestHeader0194, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0194 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [195] <- WEB ADMIN Index 195 ---
		String requestProt0195 = "https";
		String requestHost0195 = "preprod-teck.isometrix.net";
		int    requestPort0195 = 443;
		String requestFile0195 = "//scripts/kendo/cultures/kendo.culture.en-ZA.min.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0195 = Lib.replaceTextPattern(requestFile0195, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0195 = "GET " + requestFile0195 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0195, requestHost0195, requestPort0195, requestHeader0195, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0195 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [196] <- WEB ADMIN Index 196 ---
		String requestProt0196 = "https";
		String requestHost0196 = "preprod-teck.isometrix.net";
		int    requestPort0196 = 443;
		String requestFile0196 = "//page/Viewer/Form" +
				"?instanceId=06a92b5e-4170-473c-b9f9-cff06ab14c74" +
				"&browser=";
		String requestHeader0196 = "GET " + requestFile0196 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0196, requestHost0196, requestPort0196, requestHeader0196, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0196 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [197] <- WEB ADMIN Index 197 ---
		String requestProt0197 = "https";
		String requestHost0197 = "preprod-teck.isometrix.net";
		int    requestPort0197 = 443;
		String requestFile0197 = "//images/layout/editable.png";
		String requestHeader0197 = "GET " + requestFile0197 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0197, requestHost0197, requestPort0197, requestHeader0197, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0197 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [198] <- WEB ADMIN Index 198 ---
		String requestProt0198 = "https";
		String requestHost0198 = "preprod-teck.isometrix.net";
		int    requestPort0198 = 443;
		String requestFile0198 = "//images/icheck/icheck@2x.png";
		String requestHeader0198 = "GET " + requestFile0198 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0198, requestHost0198, requestPort0198, requestHeader0198, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0198 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [199] <- WEB ADMIN Index 199 ---
		String requestProt0199 = "https";
		String requestHost0199 = "preprod-teck.isometrix.net";
		int    requestPort0199 = 443;
		String requestFile0199 = "//page/Viewer/Permissions";
		String requestContent0199 = 
				"[\"06a92b5e-4170-473c-b9f9-cff06ab14c74\",\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"F2B30B35-89DC-4240-9215-955ED2654FC0\",\"574A5D07-EEFE-4030-B83A-FD0F85B0B7E6\"]";
		byte[] requestContentBinary0199 = requestContent0199.getBytes("UTF-8");
		String requestHeader0199 = "POST " + requestFile0199 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0199.length + "\r\n" + 		// Content-Length: 157
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0199, requestHost0199, requestPort0199, requestHeader0199, requestContentBinary0199, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0199 = null;		// support garbage collector to reduce memory
		requestContent0199 = null;		// support garbage collector to reduce memory
		requestContentBinary0199 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 388
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "[{\"moduleInstanceId\":\"");		// Test [199] <- Index 199
		if(replayMode)
		{
			long proxyDataRecordId =1617042271726L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [200] <- WEB ADMIN Index 200 ---
		String requestProt0200 = "https";
		String requestHost0200 = "preprod-teck.isometrix.net";
		int    requestPort0200 = 443;
		String requestFile0200 = "//css/kendo/fonts/glyphs/WebComponentsIcons.ttf" +
				"?gedxeo";
		String requestHeader0200 = "GET " + requestFile0200 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0200, requestHost0200, requestPort0200, requestHeader0200, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0200 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [201] <- WEB ADMIN Index 201 ---
		String requestProt0201 = "https";
		String requestHost0201 = "preprod-teck.isometrix.net";
		int    requestPort0201 = 443;
		String requestFile0201 = "//images/ibutton/ibutton-slider-default.png";
		String requestHeader0201 = "GET " + requestFile0201 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0201, requestHost0201, requestPort0201, requestHeader0201, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0201 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [202] <- WEB ADMIN Index 202 ---
		String requestProt0202 = "https";
		String requestHost0202 = "preprod-teck.isometrix.net";
		int    requestPort0202 = 443;
		String requestFile0202 = "//images/ibutton/no.png";
		String requestHeader0202 = "GET " + requestFile0202 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0202, requestHost0202, requestPort0202, requestHeader0202, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0202 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [203] <- WEB ADMIN Index 203 ---
		String requestProt0203 = "https";
		String requestHost0203 = "preprod-teck.isometrix.net";
		int    requestPort0203 = 443;
		String requestFile0203 = "//images/ibutton/yes.png";
		String requestHeader0203 = "GET " + requestFile0203 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0203, requestHost0203, requestPort0203, requestHeader0203, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0203 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #6_1 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #7.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_7(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #7: Search
		// # ---------------



		// --- HTTP REQUEST: Test [205] <- WEB ADMIN Index 205 ---
		String requestProt0205 = "https";
		String requestHost0205 = "preprod-teck.isometrix.net";
		int    requestPort0205 = 443;
		String requestFile0205 = "//page/Viewer/Search";
		String requestContent0205 = 
				"{\"item\":[{\"moduleID\":\"AA1B0698-3842-4AF2-921B-65A0B54DA52A\",\"hierarchy_level\":\"1\",\"instanceID\":\"06A92B5E-4170-473C-B9F9-CFF06AB14C74\",\"parentInstanceId\":\"\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":1,\"resultset\":\"1\",\"resultoptiononly\":1,\"row\":1,\"data\":{\"items\":[{\"moduledefinitionid\":\"EC3A2A64-5223-4AD1-8FA8-CA7E5C86FD56\",\"value\":\"0\",\"value2\":\"\",\"matchtype\":\"equal_to\",\"filtertype\":\"\",\"factor\":\"\",\"includechilditems\":\"\",\"andor\":\"and\",\"row\":1,\"control_type\":\"chk\",\"is_system\":false,\"module_definition_name\":\"chk1\"}]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1}]}},{\"moduleID\":\"A5C747DE-9C76-4BC2-8EB2-A49A5447D105\",\"hierarchy_level\":\"2\",\"instanceID\":\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"parentInstanceId\":\"06A92B5E-4170-473C-B9F9-CFF06AB14C74\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":0,\"resultset\":\"0\",\"resultoptiononly\":1,\"row\":2,\"data\":{\"items\":[]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":2}]}},{\"moduleID\":\"8E8EE0EE-4F27-41E7-A552-1535FF05D3F4\",\"hierarchy_level\":\"3\",\"instanceID\":\"8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2\",\"parentInstanceId\":\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":0,\"resultset\":\"0\",\"resultoptiononly\":1,\"row\":3,\"data\":{\"items\":[]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":3}]}}],\"callMdg\":\"0\",\"iscentralmodule\":\"0\",\"resultoptiononly\":\"1\",\"use_net_filter\":true}";
		byte[] requestContentBinary0205 = requestContent0205.getBytes("UTF-8");
		String requestHeader0205 = "POST " + requestFile0205 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0205.length + "\r\n" + 		// Content-Length: 1690
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0205, requestHost0205, requestPort0205, requestHeader0205, requestContentBinary0205, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0205 = null;		// support garbage collector to reduce memory
		requestContent0205 = null;		// support garbage collector to reduce memory
		requestContentBinary0205 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1315
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "QB2 External\",\"items\"");		// Test [205] <- Index 205
		if(replayMode)
		{
			long proxyDataRecordId =1617042284485L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #7 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #8.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_8(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #8: selectQB2
		// # ------------------



		// --- HTTP REQUEST: Test [207] <- WEB ADMIN Index 207 ---
		String requestProt0207 = "https";
		String requestHost0207 = "preprod-teck.isometrix.net";
		int    requestPort0207 = 443;
		String requestFile0207 = "//images/jstree/throbber.gif";
		String requestHeader0207 = "GET " + requestFile0207 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0207, requestHost0207, requestPort0207, requestHeader0207, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0207 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/GIF", header text fragment = [verification disabled], recorded content size = 1849
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/GIF", null, null);		// Test [207] <- Index 207
		if(replayMode)
		{
			long proxyDataRecordId =1617042304493L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [208] <- WEB ADMIN Index 208 ---
		String requestProt0208 = "https";
		String requestHost0208 = "preprod-teck.isometrix.net";
		int    requestPort0208 = 443;
		String requestFile0208 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0208 = 
				"{data: '[{\"id\":\"65183c0b\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;DA0A2255-D510-4B50-AE3B-36F48D5B7FFE&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;0&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}},{\"id\":\"6a60d1bf\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F5FD8DA2-3CD8-45D8-9312-4160D8AB7B85&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;0&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}}]' }";
		byte[] requestContentBinary0208 = requestContent0208.getBytes("UTF-8");
		String requestHeader0208 = "POST " + requestFile0208 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0208.length + "\r\n" + 		// Content-Length: 1162
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0208, requestHost0208, requestPort0208, requestHeader0208, requestContentBinary0208, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0208 = null;		// support garbage collector to reduce memory
		requestContent0208 = null;		// support garbage collector to reduce memory
		requestContentBinary0208 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 591
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [208] <- Index 208
		if(replayMode)
		{
			long proxyDataRecordId =1617042304591L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [209] <- WEB ADMIN Index 209 ---
		String requestProt0209 = "https";
		String requestHost0209 = "preprod-teck.isometrix.net";
		int    requestPort0209 = 443;
		String requestFile0209 = "//page/Viewer/RecordData" +
				"?recordId=D2DE9919-453F-42BB-8F62-7340FDF0B22A" +
				"&moduleId=AA1B0698-3842-4AF2-921B-65A0B54DA52A" +
				"&moduleInstanceId=06A92B5E-4170-473C-B9F9-CFF06AB14C74";
		String requestHeader0209 = "GET " + requestFile0209 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0209, requestHost0209, requestPort0209, requestHeader0209, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0209 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [210] <- WEB ADMIN Index 210 ---
		String requestProt0210 = "https";
		String requestHost0210 = "preprod-teck.isometrix.net";
		int    requestPort0210 = 443;
		String requestFile0210 = "//images/jstree/32px.png";
		String requestHeader0210 = "GET " + requestFile0210 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0210, requestHost0210, requestPort0210, requestHeader0210, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0210 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [211] <- WEB ADMIN Index 211 ---
		String requestProt0211 = "https";
		String requestHost0211 = "preprod-teck.isometrix.net";
		int    requestPort0211 = 443;
		String requestFile0211 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0211 = 
				"{data: '[{\"id\":\"639ee054\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F2944F64-A231-4273-9388-CB22351B6396&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;1&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[{&quot;type&quot;:&quot;security&quot;,&quot;filtertype&quot;:&quot;&quot;,&quot;matchtype&quot;:&quot;equal_to&quot;,&quot;control&quot;:&quot;Level&quot;,&quot;andor&quot;:&quot;and&quot;,&quot;ms_hierarchy_level&quot;:&quot;&quot;,&quot;link_min&quot;:&quot;&quot;,&quot;link_max&quot;:&quot;&quot;,&quot;row&quot;:&quot;1&quot;,&quot;controlId&quot;:&quot;&quot;,&quot;controlGuid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;recordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;parentRecordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;values_specified&quot;:false,&quot;values&quot;:[&quot;00000000-0000-0000-0000-000000000000&quot;]}]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}},{\"id\":\"3e830136\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F2944F64-A231-4273-9388-CB22351B6396&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;1&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[{&quot;type&quot;:&quot;security&quot;,&quot;filtertype&quot;:&quot;&quot;,&quot;matchtype&quot;:&quot;equal_to&quot;,&quot;control&quot;:&quot;Level&quot;,&quot;andor&quot;:&quot;and&quot;,&quot;ms_hierarchy_level&quot;:&quot;&quot;,&quot;link_min&quot;:&quot;&quot;,&quot;link_max&quot;:&quot;&quot;,&quot;row&quot;:&quot;1&quot;,&quot;controlId&quot;:&quot;&quot;,&quot;controlGuid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;recordId&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;parentRecordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;values_specified&quot;:true,&quot;values&quot;:[&quot;6d5205c7-1f4a-46a4-b213-0244911b844e&quot;]}]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}}]' }";
		byte[] requestContentBinary0211 = requestContent0211.getBytes("UTF-8");
		String requestHeader0211 = "POST " + requestFile0211 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0211.length + "\r\n" + 		// Content-Length: 2543
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0211, requestHost0211, requestPort0211, requestHeader0211, requestContentBinary0211, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0211 = null;		// support garbage collector to reduce memory
		requestContent0211 = null;		// support garbage collector to reduce memory
		requestContentBinary0211 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 883
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [211] <- Index 211
		if(replayMode)
		{
			long proxyDataRecordId =1617042306601L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [212] <- WEB ADMIN Index 212 ---
		String requestProt0212 = "https";
		String requestHost0212 = "preprod-teck.isometrix.net";
		int    requestPort0212 = 443;
		String requestFile0212 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0212 = 
				"{data: '[{\"id\":\"390b1b26\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;A5C747DE-9C76-4BC2-8EB2-A49A5447D105&quot;,&quot;hierarchy_level&quot;:&quot;2&quot;,&quot;instanceID&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;parentInstanceId&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1}]}},{&quot;moduleID&quot;:&quot;8E8EE0EE-4F27-41E7-A552-1535FF05D3F4&quot;,&quot;hierarchy_level&quot;:&quot;3&quot;,&quot;instanceID&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;parentInstanceId&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;anc_recordid&quot;:&quot;&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:0,&quot;resultset&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:2,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:2}]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0212 = requestContent0212.getBytes("UTF-8");
		String requestHeader0212 = "POST " + requestFile0212 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0212.length + "\r\n" + 		// Content-Length: 1905
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0212, requestHost0212, requestPort0212, requestHeader0212, requestContentBinary0212, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0212 = null;		// support garbage collector to reduce memory
		requestContent0212 = null;		// support garbage collector to reduce memory
		requestContentBinary0212 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 3765
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [212] <- Index 212
		if(replayMode)
		{
			long proxyDataRecordId =1617042306602L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #8 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #9.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_9(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #9: OpenRCASourceDoc
		// # -------------------------



		// --- HTTP REQUEST: Test [214] <- WEB ADMIN Index 214 ---
		String requestProt0214 = "https";
		String requestHost0214 = "preprod-teck.isometrix.net";
		int    requestPort0214 = 443;
		String requestFile0214 = "//page/Viewer/RecordData";
		String requestContent0214 = 
				"{\"items\":[{\"id\":\"d2de9919-453f-42bb-8f62-7340fdf0b22a\",\"moduleid\":\"AA1B0698-3842-4AF2-921B-65A0B54DA52A\",\"instanceid\":\"06A92B5E-4170-473C-B9F9-CFF06AB14C74\",\"processflowid\":\"E22F91AC-910E-4DC2-9889-F494BA6CCA75\",\"recordnumber\":0,\"dv\":\"2021-03-29T18:18:42.14\",\"row\":4,\"data\":{\"item\":[{\"id\":\"\",\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"identifier\":\"\",\"value\":\"6d5205c7-1f4a-46a4-b213-0244911b844e\",\"hierarchy_level\":\"3\",\"row\":4,\"ctltype\":\"ddl\",\"factor\":\"\",\"text\":\"QB2\",\"value_text_full\":\"Chile -> Regi\u00F3n de Tarapac\u00E1 -> QB2\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"814e7b22-f6c3-4ca6-b823-498ffddffec1\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Business & Financial\",\"value_text_full\":\"Business & Financial\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"b38c4a28-05f9-423d-a53e-3d2940d29f6f\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Communities of Interest\",\"value_text_full\":\"Communities of Interest\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"c37f2682-ce80-4478-8083-67106676125e\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Environment\",\"value_text_full\":\"Environment\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"b7efcb13-f807-4f2f-8366-6698e75bb031\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Health & Safety\",\"value_text_full\":\"Health & Safety\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"b115524e-8cbb-45e6-afea-63c0edd29db7\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Obligations / Legal\",\"value_text_full\":\"Obligations / Legal\"},{\"id\":\"\",\"moduledefinitionid\":\"4A1CF3FF-4E24-4F15-909B-8E3957B3CA7A\",\"identifier\":\"\",\"value\":\"ab1ad829-1d01-4245-b4d1-dd3113884d13\",\"hierarchy_level\":\"1\",\"row\":4,\"ctltype\":\"cbl\",\"factor\":\"\",\"text\":\"Reputation\",\"value_text_full\":\"Reputation\"}],\"row\":4},\"checklist\":{\"item\":[]},\"ancestor\":{\"item\":[null]},\"checkliststatusid\":\"\"}]}";
		requestContent0214 = Lib.replaceTextPattern(requestContent0214, "2021-03-29T18:18:42.14", C_Timestamp1, 0);		// search and replace content fragment "2021-03-29T18:18:42.14" with variable 'C_Timestamp1' on all occurrences

		byte[] requestContentBinary0214 = requestContent0214.getBytes("UTF-8");
		String requestHeader0214 = "POST " + requestFile0214 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0214.length + "\r\n" + 		// Content-Length: 2158
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0214, requestHost0214, requestPort0214, requestHeader0214, requestContentBinary0214, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0214 = null;		// support garbage collector to reduce memory
		requestContent0214 = null;		// support garbage collector to reduce memory
		requestContentBinary0214 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 820
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"ModuleInstanceRecords\":[{\"row\":");		// Test [214] <- Index 214
		if(replayMode)
		{
			long proxyDataRecordId =1617042327850L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [215] <- WEB ADMIN Index 215 ---
		String requestProt0215 = "https";
		String requestHost0215 = "preprod-teck.isometrix.net";
		int    requestPort0215 = 443;
		String requestFile0215 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0215 = 
				"{data: '[{\"id\":\"b372a2eb\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;A5C747DE-9C76-4BC2-8EB2-A49A5447D105&quot;,&quot;hierarchy_level&quot;:&quot;2&quot;,&quot;instanceID&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;parentInstanceId&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1}]}},{&quot;moduleID&quot;:&quot;8E8EE0EE-4F27-41E7-A552-1535FF05D3F4&quot;,&quot;hierarchy_level&quot;:&quot;3&quot;,&quot;instanceID&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;parentInstanceId&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;anc_recordid&quot;:&quot;&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:0,&quot;resultset&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:2,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:2}]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0215 = requestContent0215.getBytes("UTF-8");
		String requestHeader0215 = "POST " + requestFile0215 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0215.length + "\r\n" + 		// Content-Length: 1905
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0215, requestHost0215, requestPort0215, requestHeader0215, requestContentBinary0215, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0215 = null;		// support garbage collector to reduce memory
		requestContent0215 = null;		// support garbage collector to reduce memory
		requestContentBinary0215 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 3766
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [215] <- Index 215
		if(replayMode)
		{
			long proxyDataRecordId =1617042330560L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [216] <- WEB ADMIN Index 216 ---
		String requestProt0216 = "https";
		String requestHost0216 = "preprod-teck.isometrix.net";
		int    requestPort0216 = 443;
		String requestFile0216 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0216 = 
				"{data: '[{\"id\":\"1369ebca\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F2944F64-A231-4273-9388-CB22351B6396&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;1&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[{&quot;type&quot;:&quot;security&quot;,&quot;filtertype&quot;:&quot;&quot;,&quot;matchtype&quot;:&quot;equal_to&quot;,&quot;control&quot;:&quot;Level&quot;,&quot;andor&quot;:&quot;and&quot;,&quot;ms_hierarchy_level&quot;:&quot;&quot;,&quot;link_min&quot;:&quot;&quot;,&quot;link_max&quot;:&quot;&quot;,&quot;row&quot;:&quot;1&quot;,&quot;controlId&quot;:&quot;&quot;,&quot;controlGuid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;recordId&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;parentRecordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;values_specified&quot;:true,&quot;values&quot;:[&quot;6d5205c7-1f4a-46a4-b213-0244911b844e&quot;]}]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}}]' }";
		byte[] requestContentBinary0216 = requestContent0216.getBytes("UTF-8");
		String requestHeader0216 = "POST " + requestFile0216 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0216.length + "\r\n" + 		// Content-Length: 1277
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0216, requestHost0216, requestPort0216, requestHeader0216, requestContentBinary0216, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0216 = null;		// support garbage collector to reduce memory
		requestContent0216 = null;		// support garbage collector to reduce memory
		requestContentBinary0216 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 856
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [216] <- Index 216
		if(replayMode)
		{
			long proxyDataRecordId =1617042330562L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [217] <- WEB ADMIN Index 217 ---
		String requestProt0217 = "https";
		String requestHost0217 = "preprod-teck.isometrix.net";
		int    requestPort0217 = 443;
		String requestFile0217 = "//images/buttons/back.png";
		String requestHeader0217 = "GET " + requestFile0217 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: image/webp,*/*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0217, requestHost0217, requestPort0217, requestHeader0217, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		testURL.replaceRequestHeaderFieldTextPattern("4.17.1.1", C_JSVersion);		// search within all request header fields a text pattern and replace it with a variable value
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0217 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [218] <- WEB ADMIN Index 218 ---
		String requestProt0218 = "https";
		String requestHost0218 = "preprod-teck.isometrix.net";
		int    requestPort0218 = 443;
		String requestFile0218 = "//page/Viewer/RecordData" +
				"?recordId=45488B33-5142-4918-BCCF-EFB643C175B0" +
				"&moduleId=A5C747DE-9C76-4BC2-8EB2-A49A5447D105" +
				"&moduleInstanceId=29DAE2B0-C71B-4599-8899-9A431EA65963";
		String requestHeader0218 = "GET " + requestFile0218 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0218, requestHost0218, requestPort0218, requestHeader0218, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0218 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [219] <- WEB ADMIN Index 219 ---
		String requestProt0219 = "https";
		String requestHost0219 = "preprod-teck.isometrix.net";
		int    requestPort0219 = 443;
		String requestFile0219 = "//page/Viewer/Form" +
				"?instanceId=8592ce8f-cc84-4525-a6fa-7f8f1eb1b5b2" +
				"&browser=";
		String requestHeader0219 = "GET " + requestFile0219 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0219, requestHost0219, requestPort0219, requestHeader0219, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0219 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [220] <- WEB ADMIN Index 220 ---
		String requestProt0220 = "https";
		String requestHost0220 = "preprod-teck.isometrix.net";
		int    requestPort0220 = 443;
		String requestFile0220 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0220 = 
				"{data: '[{\"id\":\"5a42fff7\",\"detail\":{\"theUrl\":\"page/Viewer/GetLookupValue\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;lookupmoduleinstanceid&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;lookupmoduledefinitionid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;moduleinstanceid&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;moduledefinitionid&quot;:&quot;42A8797E-92E6-4208-AA4A-478CE7EFB6A2&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;recordid&quot;:&quot;45488b33-5142-4918-bccf-efb643c175b0&quot;}]}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0220 = requestContent0220.getBytes("UTF-8");
		String requestHeader0220 = "POST " + requestFile0220 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0220.length + "\r\n" + 		// Content-Length: 638
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0220, requestHost0220, requestPort0220, requestHeader0220, requestContentBinary0220, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0220 = null;		// support garbage collector to reduce memory
		requestContent0220 = null;		// support garbage collector to reduce memory
		requestContentBinary0220 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 365
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [220] <- Index 220
		if(replayMode)
		{
			long proxyDataRecordId =1617042332372L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [221] <- WEB ADMIN Index 221 ---
		String requestProt0221 = "https";
		String requestHost0221 = "preprod-teck.isometrix.net";
		int    requestPort0221 = 443;
		String requestFile0221 = "//page/Viewer/Permissions";
		String requestContent0221 = 
				"[\"8592ce8f-cc84-4525-a6fa-7f8f1eb1b5b2\",\"F47B68D9-04F1-436D-960B-AFE12D4FA041\",\"C8DBF79F-EB34-4FB2-9C5D-D0EA1C046CAA\",\"69D5A28D-A662-4E32-A3F1-5C1021487B94\",\"DA65AE5F-3B6D-4C1C-A647-D38E88A3A46E\",\"C31131AD-DC8B-4750-8F01-3656548E1A75\",\"E06649F8-965C-441C-B851-B8B5992A01FE\",\"9E174536-56C4-4095-BEC9-E56E839F50FB\",\"3A80F1F4-AE90-47B2-B9BB-0C920589C04D\",\"FCC37D71-A621-4EE0-876B-116E12BA9D85\",\"0C4323BC-931E-4D57-B7E6-8919D1A35165\",\"10C56277-BF3D-4C75-BE8A-F6F46BB33480\",\"D9A8DB93-E3EF-4C40-B3B9-5FE8F6D5AFE2\",\"5D7803E9-4DD1-49D1-8EAB-7FC8FE72C20D\",\"0C4323BC-931E-4D57-B7E6-8919D1A35165\",\"8031EE6E-22B3-4C30-AD7F-2802228607C4\"]";
		byte[] requestContentBinary0221 = requestContent0221.getBytes("UTF-8");
		String requestHeader0221 = "POST " + requestFile0221 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0221.length + "\r\n" + 		// Content-Length: 625
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0221, requestHost0221, requestPort0221, requestHeader0221, requestContentBinary0221, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0221 = null;		// support garbage collector to reduce memory
		requestContent0221 = null;		// support garbage collector to reduce memory
		requestContentBinary0221 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 818
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "[{\"moduleInstanceId\":\"");		// Test [221] <- Index 221
		if(replayMode)
		{
			long proxyDataRecordId =1617042337616L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [222] <- WEB ADMIN Index 222 ---
		String requestProt0222 = "https";
		String requestHost0222 = "preprod-teck.isometrix.net";
		int    requestPort0222 = 443;
		String requestFile0222 = "//page/Viewer/Search";
		String requestContent0222 = 
				"{\"item\":[{\"moduleID\":\"8E8EE0EE-4F27-41E7-A552-1535FF05D3F4\",\"hierarchy_level\":\"3\",\"instanceID\":\"8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2\",\"parentInstanceId\":\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"anc_recordid\":\"45488b33-5142-4918-bccf-efb643c175b0\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":30,\"root\":1,\"resultset\":\"1\",\"resultoptiononly\":1,\"row\":1,\"data\":{\"items\":[]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5E82B130-828E-46A9-8C87-61903FE8D296\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1},{\"moduledefinitionid\":\"F58ED28F-0415-4424-8C26-6B3565D1133C\",\"sortorder\":2,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1},{\"moduledefinitionid\":\"68D25FD8-4AD7-4C5C-8921-FF2DF48C4C46\",\"sortorder\":3,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1},{\"moduledefinitionid\":\"060BB53C-3368-4843-B7BE-00292AB79886\",\"sortorder\":4,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1}]}}],\"callMdg\":\"0\",\"iscentralmodule\":\"0\",\"resultoptiononly\":\"1\",\"use_net_filter\":true}";
		byte[] requestContentBinary0222 = requestContent0222.getBytes("UTF-8");
		String requestHeader0222 = "POST " + requestFile0222 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0222.length + "\r\n" + 		// Content-Length: 927
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0222, requestHost0222, requestPort0222, requestHeader0222, requestContentBinary0222, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0222 = null;		// support garbage collector to reduce memory
		requestContent0222 = null;		// support garbage collector to reduce memory
		requestContentBinary0222 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8732
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"data\":[{\"moduleid\":{\"text\":");		// Test [222] <- Index 222
		if(replayMode)
		{
			long proxyDataRecordId =1617042337650L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #9 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #10.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_10(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #10: OpenObligation
		// # ------------------------



		// --- HTTP REQUEST: Test [224] <- WEB ADMIN Index 224 ---
		String requestProt0224 = "https";
		String requestHost0224 = "preprod-teck.isometrix.net";
		int    requestPort0224 = 443;
		String requestFile0224 = "//scripts/core.mapbox.arcgis.js";
		String requestHeader0224 = "GET " + requestFile0224 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0224, requestHost0224, requestPort0224, requestHeader0224, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0224 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 7784
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [224] <- Index 224
		if(replayMode)
		{
			long proxyDataRecordId =1617042357221L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [225] <- WEB ADMIN Index 225 ---
		String requestProt0225 = "https";
		String requestHost0225 = "preprod-teck.isometrix.net";
		int    requestPort0225 = 443;
		String requestFile0225 = "//css/core.mapbox.arcgis.css";
		String requestHeader0225 = "GET " + requestFile0225 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/css,*/*;q=0.1\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0225, requestHost0225, requestPort0225, requestHeader0225, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0225 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [226] <- WEB ADMIN Index 226 ---
		String requestProt0226 = "https";
		String requestHost0226 = "preprod-teck.isometrix.net";
		int    requestPort0226 = 443;
		String requestFile0226 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0226 = 
				requestFileCache.readFile(getSymmetricEncryptContext(), "OpenObligation_LT_RequestContent0226.txt").getFileDataAsString("UTF-8");		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		byte[] requestContentBinary0226 = requestContent0226.getBytes("UTF-8");
		String requestHeader0226 = "POST " + requestFile0226 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0226.length + "\r\n" + 		// Content-Length: 7412
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0226, requestHost0226, requestPort0226, requestHeader0226, requestContentBinary0226, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0226 = null;		// support garbage collector to reduce memory
		requestContent0226 = null;		// support garbage collector to reduce memory
		requestContentBinary0226 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 78406
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [226] <- Index 226
		if(replayMode)
		{
			long proxyDataRecordId =1617042357718L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [227] <- WEB ADMIN Index 227 ---
		String requestProt0227 = "https";
		String requestHost0227 = "preprod-teck.isometrix.net";
		int    requestPort0227 = 443;
		String requestFile0227 = "//page/Viewer/RecordData" +
				"?recordId=561A2FAF-C58F-4C6E-955B-A6FBCAC6B7AC" +
				"&moduleId=8E8EE0EE-4F27-41E7-A552-1535FF05D3F4" +
				"&moduleInstanceId=8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2";
		String requestHeader0227 = "GET " + requestFile0227 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0227, requestHost0227, requestPort0227, requestHeader0227, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0227 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [228] <- WEB ADMIN Index 228 ---
		String requestProt0228 = "https";
		String requestHost0228 = "preprod-teck.isometrix.net";
		int    requestPort0228 = 443;
		String requestFile0228 = "//page/Viewer/GetConsolidatedData";
		String requestContent0228 = 
				"{\"items\":[{\"moduleid\":\"8E8EE0EE-4F27-41E7-A552-1535FF05D3F4\",\"instanceid\":\"8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2\",\"exclude_recordid\":\"561a2faf-c58f-4c6e-955b-a6fbcac6b7ac\",\"ancrecordid\":\"\",\"page\":1,\"offset\":0,\"limit\":20,\"root\":1,\"resultoptiononly\":true,\"resultset\":1,\"row\":1,\"data\":{\"items\":[]},\"controltype\":{\"items\":[{\"id\":\"AA98B180-38C1-4492-A936-EB9D5ED2AAAC\"}]}}]}";
		byte[] requestContentBinary0228 = requestContent0228.getBytes("UTF-8");
		String requestHeader0228 = "POST " + requestFile0228 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0228.length + "\r\n" + 		// Content-Length: 368
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0228, requestHost0228, requestPort0228, requestHeader0228, requestContentBinary0228, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0228 = null;		// support garbage collector to reduce memory
		requestContent0228 = null;		// support garbage collector to reduce memory
		requestContentBinary0228 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 193
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"Records\":[{\"Id\":");		// Test [228] <- Index 228
		if(replayMode)
		{
			long proxyDataRecordId =1617042360307L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [229] <- WEB ADMIN Index 229 ---
		String requestProt0229 = "https";
		String requestHost0229 = "preprod-teck.isometrix.net";
		int    requestPort0229 = 443;
		String requestFile0229 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0229 = 
				requestFileCache.readFile(getSymmetricEncryptContext(), "OpenObligation_LT_RequestContent0229.txt").getFileDataAsString("UTF-8");		// note: consider duplicated definition of this file name near end of the load test program - used for ZIP-dialogue in Project Navigator
		byte[] requestContentBinary0229 = requestContent0229.getBytes("UTF-8");
		String requestHeader0229 = "POST " + requestFile0229 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0229.length + "\r\n" + 		// Content-Length: 13037
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0229, requestHost0229, requestPort0229, requestHeader0229, requestContentBinary0229, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0229 = null;		// support garbage collector to reduce memory
		requestContent0229 = null;		// support garbage collector to reduce memory
		requestContentBinary0229 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8317
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [229] <- Index 229
		if(replayMode)
		{
			long proxyDataRecordId =1617042360772L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [230] <- WEB ADMIN Index 230 ---
		String requestProt0230 = "https";
		String requestHost0230 = "preprod-teck.isometrix.net";
		int    requestPort0230 = 443;
		String requestFile0230 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0230 = 
				"{data: '[{\"id\":\"5dd2d520\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;C3AFCAA0-0DB2-428A-ADF9-91E53EBA72B4&quot;,&quot;hierarchy_level&quot;:&quot;1&quot;,&quot;instanceID&quot;:&quot;0C4323BC-931E-4D57-B7E6-8919D1A35165&quot;,&quot;parentInstanceId&quot;:&quot;&quot;,&quot;anc_recordid&quot;:&quot;&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:10,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}},{\"id\":\"a74e6121\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;B23F0811-C607-4F4E-B788-D87770FC9C5A&quot;,&quot;hierarchy_level&quot;:&quot;4&quot;,&quot;instanceID&quot;:&quot;8031EE6E-22B3-4C30-AD7F-2802228607C4&quot;,&quot;parentInstanceId&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;anc_recordid&quot;:&quot;561a2faf-c58f-4c6e-955b-a6fbcac6b7ac&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:10,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;48C6D1DD-B63B-4522-8266-F4EEE164F10D&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1},{&quot;moduledefinitionid&quot;:&quot;D842A88A-4643-456E-A2EA-9A8EBD225928&quot;,&quot;sortorder&quot;:2,&quot;sortdir&quot;:&quot;1&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1},{&quot;moduledefinitionid&quot;:&quot;4DA9DB84-7BD2-4DC6-96E0-7F90026C2069&quot;,&quot;sortorder&quot;:3,&quot;sortdir&quot;:&quot;1&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1}]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0230 = requestContent0230.getBytes("UTF-8");
		String requestHeader0230 = "POST " + requestFile0230 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0230.length + "\r\n" + 		// Content-Length: 2360
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0230, requestHost0230, requestPort0230, requestHeader0230, requestContentBinary0230, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0230 = null;		// support garbage collector to reduce memory
		requestContent0230 = null;		// support garbage collector to reduce memory
		requestContentBinary0230 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 8056
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [230] <- Index 230
		if(replayMode)
		{
			long proxyDataRecordId =1617042360774L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [231] <- WEB ADMIN Index 231 ---
		String requestProt0231 = "https";
		String requestHost0231 = "preprod-teck.isometrix.net";
		int    requestPort0231 = 443;
		String requestFile0231 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0231 = 
				"{data: '[{\"id\":\"126a4b6e\",\"detail\":{\"theUrl\":\"page/Viewer/GetLookupValue\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;lookupmoduleinstanceid&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;lookupmoduledefinitionid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;moduleinstanceid&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;moduledefinitionid&quot;:&quot;742AC39A-6DBF-47BD-B254-7089B146EB0C&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;recordid&quot;:&quot;561a2faf-c58f-4c6e-955b-a6fbcac6b7ac&quot;}]}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0231 = requestContent0231.getBytes("UTF-8");
		String requestHeader0231 = "POST " + requestFile0231 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0231.length + "\r\n" + 		// Content-Length: 638
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0231, requestHost0231, requestPort0231, requestHeader0231, requestContentBinary0231, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0231 = null;		// support garbage collector to reduce memory
		requestContent0231 = null;		// support garbage collector to reduce memory
		requestContentBinary0231 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 364
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [231] <- Index 231
		if(replayMode)
		{
			long proxyDataRecordId =1617042360777L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [232] <- WEB ADMIN Index 232 ---
		String requestProt0232 = "https";
		String requestHost0232 = "preprod-teck.isometrix.net";
		int    requestPort0232 = 443;
		String requestFile0232 = "//page/Viewer/GetConsolidatedData";
		String requestContent0232 = 
				"{\"items\":[{\"moduleid\":\"8E8EE0EE-4F27-41E7-A552-1535FF05D3F4\",\"instanceid\":\"8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2\",\"exclude_recordid\":\"561a2faf-c58f-4c6e-955b-a6fbcac6b7ac\",\"ancrecordid\":\"\",\"page\":1,\"offset\":0,\"limit\":20,\"root\":1,\"resultoptiononly\":true,\"resultset\":1,\"row\":1,\"data\":{\"items\":[]},\"controltype\":{\"items\":[{\"id\":\"AA98B180-38C1-4492-A936-EB9D5ED2AAAC\"}]}}]}";
		byte[] requestContentBinary0232 = requestContent0232.getBytes("UTF-8");
		String requestHeader0232 = "POST " + requestFile0232 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0232.length + "\r\n" + 		// Content-Length: 368
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0232, requestHost0232, requestPort0232, requestHeader0232, requestContentBinary0232, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0232 = null;		// support garbage collector to reduce memory
		requestContent0232 = null;		// support garbage collector to reduce memory
		requestContentBinary0232 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 193
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"Records\":[{\"Id\":");		// Test [232] <- Index 232
		if(replayMode)
		{
			long proxyDataRecordId =1617042360824L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #10 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #11.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_11(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #11: CloseRecord
		// # ---------------------



		// --- HTTP REQUEST: Test [234] <- WEB ADMIN Index 234 ---
		String requestProt0234 = "https";
		String requestHost0234 = "preprod-teck.isometrix.net";
		int    requestPort0234 = 443;
		String requestFile0234 = "//page/Viewer/RecordData" +
				"?recordId=45488b33-5142-4918-bccf-efb643c175b0" +
				"&moduleId=A5C747DE-9C76-4BC2-8EB2-A49A5447D105" +
				"&moduleInstanceId=29DAE2B0-C71B-4599-8899-9A431EA65963";
		String requestHeader0234 = "GET " + requestFile0234 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0234, requestHost0234, requestPort0234, requestHeader0234, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0234 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 2100
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "Región de Tarapacá -");		// Test [234] <- Index 234
		if(replayMode)
		{
			long proxyDataRecordId =1617042385708L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [235] <- WEB ADMIN Index 235 ---
		String requestProt0235 = "https";
		String requestHost0235 = "preprod-teck.isometrix.net";
		int    requestPort0235 = 443;
		String requestFile0235 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0235 = 
				"{data: '[{\"id\":\"f1eddfc9\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;8E8EE0EE-4F27-41E7-A552-1535FF05D3F4&quot;,&quot;hierarchy_level&quot;:&quot;3&quot;,&quot;instanceID&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;parentInstanceId&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;anc_recordid&quot;:&quot;45488b33-5142-4918-bccf-efb643c175b0&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;5E82B130-828E-46A9-8C87-61903FE8D296&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1},{&quot;moduledefinitionid&quot;:&quot;F58ED28F-0415-4424-8C26-6B3565D1133C&quot;,&quot;sortorder&quot;:2,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1},{&quot;moduledefinitionid&quot;:&quot;68D25FD8-4AD7-4C5C-8921-FF2DF48C4C46&quot;,&quot;sortorder&quot;:3,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1},{&quot;moduledefinitionid&quot;:&quot;060BB53C-3368-4843-B7BE-00292AB79886&quot;,&quot;sortorder&quot;:4,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1}]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0235 = requestContent0235.getBytes("UTF-8");
		String requestHeader0235 = "POST " + requestFile0235 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0235.length + "\r\n" + 		// Content-Length: 1703
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0235, requestHost0235, requestPort0235, requestHeader0235, requestContentBinary0235, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0235 = null;		// support garbage collector to reduce memory
		requestContent0235 = null;		// support garbage collector to reduce memory
		requestContentBinary0235 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 9154
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [235] <- Index 235
		if(replayMode)
		{
			long proxyDataRecordId =1617042386536L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [236] <- WEB ADMIN Index 236 ---
		String requestProt0236 = "https";
		String requestHost0236 = "preprod-teck.isometrix.net";
		int    requestPort0236 = 443;
		String requestFile0236 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0236 = 
				"{data: '[{\"id\":\"50deb2a5\",\"detail\":{\"theUrl\":\"page/Viewer/GetLookupValue\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;lookupmoduleinstanceid&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;lookupmoduledefinitionid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;moduleinstanceid&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;moduledefinitionid&quot;:&quot;42A8797E-92E6-4208-AA4A-478CE7EFB6A2&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;recordid&quot;:&quot;45488b33-5142-4918-bccf-efb643c175b0&quot;}]}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0236 = requestContent0236.getBytes("UTF-8");
		String requestHeader0236 = "POST " + requestFile0236 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0236.length + "\r\n" + 		// Content-Length: 638
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0236, requestHost0236, requestPort0236, requestHeader0236, requestContentBinary0236, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0236 = null;		// support garbage collector to reduce memory
		requestContent0236 = null;		// support garbage collector to reduce memory
		requestContentBinary0236 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 364
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [236] <- Index 236
		if(replayMode)
		{
			long proxyDataRecordId =1617042387226L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #11 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #12.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_12(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #12: CloseSourceDoc
		// # ------------------------



		// --- HTTP REQUEST: Test [238] <- WEB ADMIN Index 238 ---
		String requestProt0238 = "https";
		String requestHost0238 = "preprod-teck.isometrix.net";
		int    requestPort0238 = 443;
		String requestFile0238 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0238 = 
				"{data: '[{\"id\":\"bf9ffeeb\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;DA0A2255-D510-4B50-AE3B-36F48D5B7FFE&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;0&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}},{\"id\":\"2fb6a2dd\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F5FD8DA2-3CD8-45D8-9312-4160D8AB7B85&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;0&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}}]' }";
		byte[] requestContentBinary0238 = requestContent0238.getBytes("UTF-8");
		String requestHeader0238 = "POST " + requestFile0238 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0238.length + "\r\n" + 		// Content-Length: 1162
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0238, requestHost0238, requestPort0238, requestHeader0238, requestContentBinary0238, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0238 = null;		// support garbage collector to reduce memory
		requestContent0238 = null;		// support garbage collector to reduce memory
		requestContentBinary0238 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 589
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [238] <- Index 238
		if(replayMode)
		{
			long proxyDataRecordId =1617042405346L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [239] <- WEB ADMIN Index 239 ---
		String requestProt0239 = "https";
		String requestHost0239 = "preprod-teck.isometrix.net";
		int    requestPort0239 = 443;
		String requestFile0239 = "//page/Viewer/RecordData" +
				"?recordId=d2de9919-453f-42bb-8f62-7340fdf0b22a" +
				"&moduleId=AA1B0698-3842-4AF2-921B-65A0B54DA52A" +
				"&moduleInstanceId=06A92B5E-4170-473C-B9F9-CFF06AB14C74";
		String requestHeader0239 = "GET " + requestFile0239 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0239, requestHost0239, requestPort0239, requestHeader0239, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0239 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [240] <- WEB ADMIN Index 240 ---
		String requestProt0240 = "https";
		String requestHost0240 = "preprod-teck.isometrix.net";
		int    requestPort0240 = 443;
		String requestFile0240 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0240 = 
				"{data: '[{\"id\":\"17d5ddd7\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F2944F64-A231-4273-9388-CB22351B6396&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;1&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[{&quot;type&quot;:&quot;security&quot;,&quot;filtertype&quot;:&quot;&quot;,&quot;matchtype&quot;:&quot;equal_to&quot;,&quot;control&quot;:&quot;Level&quot;,&quot;andor&quot;:&quot;and&quot;,&quot;ms_hierarchy_level&quot;:&quot;&quot;,&quot;link_min&quot;:&quot;&quot;,&quot;link_max&quot;:&quot;&quot;,&quot;row&quot;:&quot;1&quot;,&quot;controlId&quot;:&quot;&quot;,&quot;controlGuid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;recordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;parentRecordId&quot;:&quot;45488b33-5142-4918-bccf-efb643c175b0&quot;,&quot;values_specified&quot;:false,&quot;values&quot;:[&quot;00000000-0000-0000-0000-000000000000&quot;]}]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}},{\"id\":\"c5153c02\",\"detail\":{\"theUrl\":\"rest/DataSource/Items\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;sourceid&quot;:&quot;F2944F64-A231-4273-9388-CB22351B6396&quot;,&quot;parent&quot;:&quot;#&quot;,&quot;page&quot;:1,&quot;pageSize&quot;:500,&quot;displayMin&quot;:0,&quot;displayMax&quot;:0,&quot;applySecurity&quot;:&quot;1&quot;,&quot;returndependants&quot;:&quot;1&quot;,&quot;loadOnDemand&quot;:false,&quot;lazyLoading&quot;:false,&quot;filter&quot;:{&quot;items&quot;:[{&quot;type&quot;:&quot;security&quot;,&quot;filtertype&quot;:&quot;&quot;,&quot;matchtype&quot;:&quot;equal_to&quot;,&quot;control&quot;:&quot;Level&quot;,&quot;andor&quot;:&quot;and&quot;,&quot;ms_hierarchy_level&quot;:&quot;&quot;,&quot;link_min&quot;:&quot;&quot;,&quot;link_max&quot;:&quot;&quot;,&quot;row&quot;:&quot;1&quot;,&quot;controlId&quot;:&quot;&quot;,&quot;controlGuid&quot;:&quot;5614586C-E586-4742-9423-A40BFA7F4E1B&quot;,&quot;recordId&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;parentRecordId&quot;:&quot;00000000-0000-0000-0000-000000000000&quot;,&quot;values_specified&quot;:true,&quot;values&quot;:[&quot;6d5205c7-1f4a-46a4-b213-0244911b844e&quot;]}]},&quot;row&quot;:&quot;1&quot;}]}\",\"Async\":true,\"deferred\":{}}}]' }";
		byte[] requestContentBinary0240 = requestContent0240.getBytes("UTF-8");
		String requestHeader0240 = "POST " + requestFile0240 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0240.length + "\r\n" + 		// Content-Length: 2543
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0240, requestHost0240, requestPort0240, requestHeader0240, requestContentBinary0240, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0240 = null;		// support garbage collector to reduce memory
		requestContent0240 = null;		// support garbage collector to reduce memory
		requestContentBinary0240 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 878
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [240] <- Index 240
		if(replayMode)
		{
			long proxyDataRecordId =1617042407137L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [241] <- WEB ADMIN Index 241 ---
		String requestProt0241 = "https";
		String requestHost0241 = "preprod-teck.isometrix.net";
		int    requestPort0241 = 443;
		String requestFile0241 = "//components/admin/common.aspx/DataUtilAggregated";
		String requestContent0241 = 
				"{data: '[{\"id\":\"2ea5b29e\",\"detail\":{\"theUrl\":\"page/Viewer/Search\",\"dataType\":\"json\",\"postOrGet\":\"post\",\"postdata\":\"{&quot;item&quot;:[{&quot;moduleID&quot;:&quot;A5C747DE-9C76-4BC2-8EB2-A49A5447D105&quot;,&quot;hierarchy_level&quot;:&quot;2&quot;,&quot;instanceID&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;parentInstanceId&quot;:&quot;06A92B5E-4170-473C-B9F9-CFF06AB14C74&quot;,&quot;anc_recordid&quot;:&quot;d2de9919-453f-42bb-8f62-7340fdf0b22a&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:1,&quot;resultset&quot;:&quot;1&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:1,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:1}]}},{&quot;moduleID&quot;:&quot;8E8EE0EE-4F27-41E7-A552-1535FF05D3F4&quot;,&quot;hierarchy_level&quot;:&quot;3&quot;,&quot;instanceID&quot;:&quot;8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2&quot;,&quot;parentInstanceId&quot;:&quot;29DAE2B0-C71B-4599-8899-9A431EA65963&quot;,&quot;anc_recordid&quot;:&quot;&quot;,&quot;anc_questionid&quot;:&quot;&quot;,&quot;page&quot;:1,&quot;offset&quot;:0,&quot;limit&quot;:30,&quot;root&quot;:0,&quot;resultset&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:1,&quot;row&quot;:2,&quot;data&quot;:{&quot;items&quot;:[]},&quot;result&quot;:{&quot;items&quot;:[{&quot;moduledefinitionid&quot;:&quot;8322E2A1-35A5-402D-BAAA-81E7C6E3A027&quot;,&quot;sortorder&quot;:1,&quot;sortdir&quot;:&quot;&quot;,&quot;grouporder&quot;:&quot;&quot;,&quot;row&quot;:2}]}}],&quot;callMdg&quot;:&quot;0&quot;,&quot;iscentralmodule&quot;:&quot;0&quot;,&quot;resultoptiononly&quot;:&quot;1&quot;,&quot;use_net_filter&quot;:true}\",\"deferred\":{}}}]' }";
		byte[] requestContentBinary0241 = requestContent0241.getBytes("UTF-8");
		String requestHeader0241 = "POST " + requestFile0241 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0241.length + "\r\n" + 		// Content-Length: 1905
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0241, requestHost0241, requestPort0241, requestHeader0241, requestContentBinary0241, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0241 = null;		// support garbage collector to reduce memory
		requestContent0241 = null;		// support garbage collector to reduce memory
		requestContentBinary0241 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 3768
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"Aggregated call Successful");		// Test [241] <- Index 241
		if(replayMode)
		{
			long proxyDataRecordId =1617042407140L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #12 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #13.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_13(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #13: closeComplianceRegister
		// # ---------------------------------



		// --- HTTP REQUEST: Test [243] <- WEB ADMIN Index 243 ---
		String requestProt0243 = "https";
		String requestHost0243 = "preprod-teck.isometrix.net";
		int    requestPort0243 = 443;
		String requestFile0243 = "//page/Viewer/Search";
		String requestContent0243 = 
				"{\"item\":[{\"moduleID\":\"AA1B0698-3842-4AF2-921B-65A0B54DA52A\",\"hierarchy_level\":\"1\",\"instanceID\":\"06A92B5E-4170-473C-B9F9-CFF06AB14C74\",\"parentInstanceId\":\"\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":1,\"resultset\":\"1\",\"resultoptiononly\":1,\"row\":1,\"data\":{\"items\":[{\"moduledefinitionid\":\"EC3A2A64-5223-4AD1-8FA8-CA7E5C86FD56\",\"value\":\"0\",\"value2\":\"\",\"matchtype\":\"equal_to\",\"filtertype\":\"\",\"factor\":\"\",\"includechilditems\":\"\",\"andor\":\"and\",\"row\":1,\"control_type\":\"chk\",\"is_system\":false,\"module_definition_name\":\"chk1\"}]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":1}]}},{\"moduleID\":\"A5C747DE-9C76-4BC2-8EB2-A49A5447D105\",\"hierarchy_level\":\"2\",\"instanceID\":\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"parentInstanceId\":\"06A92B5E-4170-473C-B9F9-CFF06AB14C74\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":0,\"resultset\":\"0\",\"resultoptiononly\":1,\"row\":2,\"data\":{\"items\":[]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":2}]}},{\"moduleID\":\"8E8EE0EE-4F27-41E7-A552-1535FF05D3F4\",\"hierarchy_level\":\"3\",\"instanceID\":\"8592CE8F-CC84-4525-A6FA-7F8F1EB1B5B2\",\"parentInstanceId\":\"29DAE2B0-C71B-4599-8899-9A431EA65963\",\"anc_recordid\":\"\",\"anc_questionid\":\"\",\"page\":1,\"offset\":0,\"limit\":10,\"root\":0,\"resultset\":\"0\",\"resultoptiononly\":1,\"row\":3,\"data\":{\"items\":[]},\"result\":{\"items\":[{\"moduledefinitionid\":\"5614586C-E586-4742-9423-A40BFA7F4E1B\",\"sortorder\":1,\"sortdir\":\"\",\"grouporder\":\"\",\"row\":3}]}}],\"callMdg\":\"0\",\"iscentralmodule\":\"0\",\"resultoptiononly\":\"1\",\"use_net_filter\":true}";
		byte[] requestContentBinary0243 = requestContent0243.getBytes("UTF-8");
		String requestHeader0243 = "POST " + requestFile0243 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0243.length + "\r\n" + 		// Content-Length: 1690
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0243, requestHost0243, requestPort0243, requestHeader0243, requestContentBinary0243, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0243 = null;		// support garbage collector to reduce memory
		requestContent0243 = null;		// support garbage collector to reduce memory
		requestContentBinary0243 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1317
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "QB2 External\",\"items\":");		// Test [243] <- Index 243
		if(replayMode)
		{
			long proxyDataRecordId =1617042429197L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated




		// all http requests of page #13 successful done
		return true;
	}


	/**
	 * Recorded http requests of page #14.
	 *
	 * @return  true:  method successful completed.
	 *          false: method/loop failed.
	 */
	boolean executePage_14(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext,int innerLoopCounter, int totalInnerLoopCount, Object httpLogVectorObject) throws Exception
	{
		// # Page #14: LogOut
		// # ----------------



		// --- HTTP REQUEST: Test [245] <- WEB ADMIN Index 245 ---
		String requestProt0245 = "https";
		String requestHost0245 = "preprod-teck.isometrix.net";
		int    requestPort0245 = 443;
		String requestFile0245 = "//default.aspx/abandonSession";
		String requestContent0245 = 
				"{}";
		byte[] requestContentBinary0245 = requestContent0245.getBytes("UTF-8");
		String requestHeader0245 = "POST " + requestFile0245 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: application/json, text/javascript, */*; q=0.01\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Content-Type: application/json; charset=utf-8\r\n" + 
				"X-Requested-With: XMLHttpRequest\r\n" + 
				"Content-Length: " + requestContentBinary0245.length + "\r\n" + 		// Content-Length: 2
				"Origin: https://preprod-teck.isometrix.net\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0245, requestHost0245, requestPort0245, requestHeader0245, requestContentBinary0245, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");
		if (debugLoops)
		{
			if (Lib.isAsciiContent(testURL.getRequestContent(), 256))
				log(">>> " + new String(testURL.getRequestContent()));
			else
				log(">>> [binary data]");
		}

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0245 = null;		// support garbage collector to reduce memory
		requestContent0245 = null;		// support garbage collector to reduce memory
		requestContentBinary0245 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 269
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "\"status\":1,\"message\":\"session abandoned\"");		// Test [245] <- Index 245
		if(replayMode)
		{
			long proxyDataRecordId =1617042440985L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [246] <- WEB ADMIN Index 246 ---
		log();
		log("# title: Object moved");
		String requestProt0246 = "https";
		String requestHost0246 = "preprod-teck.isometrix.net";
		int    requestPort0246 = 443;
		String requestFile0246 = "//login.aspx" +
				"?signout=1";
		String requestHeader0246 = "GET " + requestFile0246 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0246, requestHost0246, requestPort0246, requestHeader0246, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0246 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 301, content type = [verification disabled], header text fragment = [verification disabled], recorded content size = 33921
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {301}, null, null, null);		// Test [246] <- Index 246
		if(replayMode)
		{
			long proxyDataRecordId =1617042441249L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [247] <- WEB ADMIN Index 247 ---
		log();
		log("# title: Logout");
		String requestProt0247 = "https";
		String requestHost0247 = "preprod-teck.isometrix.net";
		int    requestPort0247 = 443;
		String requestFile0247 = "/logout.aspx";
		String requestHeader0247 = "GET " + requestFile0247 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"Upgrade-Insecure-Requests: 1\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0247, requestHost0247, requestPort0247, requestHeader0247, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		// Check for browse cache
		if(enableBrowserCache)
		{
			testURL = isInCache(testURL);
			if(!testURL.isCached())
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
			else if(conditionalGet)
			{
				testURL.execute(performanceData);
				testURL = getFromCache(testURL, performanceData);
			}
			else
			{
				testURL.execute(performanceData);
				storeToCache(testURL, performanceData);
			}
		}
		else
		{
			testURL.execute(performanceData);
		}
		requestHeader0247 = null;		// support garbage collector to reduce memory
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 3926
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "Login Checks");		// Test [247] <- Index 247
		if(replayMode)
		{
			long proxyDataRecordId =1617042441836L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated






		// --- HTTP REQUEST: Test [248] <- WEB ADMIN Index 248 ---
		String requestProt0248 = "https";
		String requestHost0248 = "preprod-teck.isometrix.net";
		int    requestPort0248 = 443;
		String requestFile0248 = "/components/language/language.aspx" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0248 = Lib.replaceTextPattern(requestFile0248, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0248 = "GET " + requestFile0248 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0248, requestHost0248, requestPort0248, requestHeader0248, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0248 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [249] <- WEB ADMIN Index 249 ---
		String requestProt0249 = "https";
		String requestHost0249 = "preprod-teck.isometrix.net";
		int    requestPort0249 = 443;
		String requestFile0249 = "/scripts/page.signout.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0249 = Lib.replaceTextPattern(requestFile0249, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0249 = "GET " + requestFile0249 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0249, requestHost0249, requestPort0249, requestHeader0249, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0249 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;





		// --- HTTP REQUEST: Test [250] <- WEB ADMIN Index 250 ---
		String requestProt0250 = "https";
		String requestHost0250 = "preprod-teck.isometrix.net";
		int    requestPort0250 = 443;
		String requestFile0250 = "/scripts/page.logout.js" +
				"?_=" + C_JSVersion;		// recorded value = 4.17.1.1
		requestFile0250 = Lib.replaceTextPattern(requestFile0250, "4.17.1.1", C_JSVersion, 0);		// search and replace request file fragment "4.17.1.1" with variable 'C_JSVersion' on all occurrences

		String requestHeader0250 = "GET " + requestFile0250 + " HTTP/" + httpProtocolVersion + "\r\n" + 
				"Host: preprod-teck.isometrix.net\r\n" + 
				"User-Agent: " + USER_AGENT_1 + "\r\n" + 
				"Accept: */*\r\n" + 
				"Accept-Language: en-US,en;q=0.5\r\n" + 
				"Accept-Encoding: gzip, deflate, br\r\n" + 
				"Connection: Keep-Alive\r\n" + 
				"\r\n";

		// execute request
		testURL = new HttpTestURL(requestProt0250, requestHost0250, requestPort0250, requestHeader0250, null, requestTimeout, socketPool, cookieHandler, httpLogVectorObject);
		if (userNextProxyConfig != null)
			testURL.setProxy(userNextProxyConfig);
		testURL.setDNSContext(userDNSContext);
		testURL.setFailureActionType(HttpTestURL.FAILURE_ACTION_IGNORE_ERROR);
		performanceData.setInfoText(threadStep, testURL, -1);		// hint: param #3 is the maximum acceptable response time in milliseconds (-1 = not configured)
		log("[" + threadStep + "] " + testURL.getRequestInfoText() + " ...");

		pageThreadHandler.insertInExecutionQueue(testURL, threadStep);
		requestHeader0250 = null;		// support garbage collector to reduce memory
		threadStep = threadStep + 1;



		// all http requests of page #14 successful done
		return true;
	}



	boolean synchResponsesParallelRequestsPage_1(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 1 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2678
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [2] <- Index 2
		if(replayMode)
		{
			long proxyDataRecordId =1617042154617L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 930
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [3] <- Index 3
		if(replayMode)
		{
			long proxyDataRecordId =1617042154881L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 4604
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [4] <- Index 4
		if(replayMode)
		{
			long proxyDataRecordId =1617042155137L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 804
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [5] <- Index 5
		if(replayMode)
		{
			long proxyDataRecordId =1617042155302L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4232
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [6] <- Index 6
		if(replayMode)
		{
			long proxyDataRecordId =1617042155323L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1105
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [7] <- Index 7
		if(replayMode)
		{
			long proxyDataRecordId =1617042155332L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2501
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [10] <- Index 10
		if(replayMode)
		{
			long proxyDataRecordId =1617042155344L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 6891
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [12] <- Index 12
		if(replayMode)
		{
			long proxyDataRecordId =1617042155352L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 895
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [13] <- Index 13
		if(replayMode)
		{
			long proxyDataRecordId =1617042155369L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2773
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [14] <- Index 14
		if(replayMode)
		{
			long proxyDataRecordId =1617042155541L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 37169
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [15] <- Index 15
		if(replayMode)
		{
			long proxyDataRecordId =1617042155557L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 9643
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [16] <- Index 16
		if(replayMode)
		{
			long proxyDataRecordId =1617042155566L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 13346
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [17] <- Index 17
		if(replayMode)
		{
			long proxyDataRecordId =1617042155588L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 12625
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [18] <- Index 18
		if(replayMode)
		{
			long proxyDataRecordId =1617042155591L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1149
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [19] <- Index 19
		if(replayMode)
		{
			long proxyDataRecordId =1617042155603L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1024
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [20] <- Index 20
		if(replayMode)
		{
			long proxyDataRecordId =1617042155783L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2809
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [21] <- Index 21
		if(replayMode)
		{
			long proxyDataRecordId =1617042155799L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 5411
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [22] <- Index 22
		if(replayMode)
		{
			long proxyDataRecordId =1617042155825L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 682
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [23] <- Index 23
		if(replayMode)
		{
			long proxyDataRecordId =1617042155830L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 391
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [24] <- Index 24
		if(replayMode)
		{
			long proxyDataRecordId =1617042156142L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4841
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [25] <- Index 25
		if(replayMode)
		{
			long proxyDataRecordId =1617042156143L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 31550
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [26] <- Index 26
		if(replayMode)
		{
			long proxyDataRecordId =1617042156144L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_1(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_1 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1171
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [27] <- Index 27
		if(replayMode)
		{
			long proxyDataRecordId =1617042156151L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [28] <- Index 28
		if(replayMode)
		{
			long proxyDataRecordId =1617042156153L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8553
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [29] <- Index 29
		if(replayMode)
		{
			long proxyDataRecordId =1617042156155L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 99593
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [30] <- Index 30
		if(replayMode)
		{
			long proxyDataRecordId =1617042156385L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2173
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [31] <- Index 31
		if(replayMode)
		{
			long proxyDataRecordId =1617042156434L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2496
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [32] <- Index 32
		if(replayMode)
		{
			long proxyDataRecordId =1617042156440L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1413
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [33] <- Index 33
		if(replayMode)
		{
			long proxyDataRecordId =1617042156449L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4301
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [34] <- Index 34
		if(replayMode)
		{
			long proxyDataRecordId =1617042156452L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4664
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [35] <- Index 35
		if(replayMode)
		{
			long proxyDataRecordId =1617042156636L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1640
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [36] <- Index 36
		if(replayMode)
		{
			long proxyDataRecordId =1617042156685L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 792205
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [37] <- Index 37
		if(replayMode)
		{
			long proxyDataRecordId =1617042156693L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 23495
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [38] <- Index 38
		if(replayMode)
		{
			long proxyDataRecordId =1617042156702L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1985
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [39] <- Index 39
		if(replayMode)
		{
			long proxyDataRecordId =1617042156704L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 22750
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [40] <- Index 40
		if(replayMode)
		{
			long proxyDataRecordId =1617042156869L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 66251
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [41] <- Index 41
		if(replayMode)
		{
			long proxyDataRecordId =1617042156877L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1659
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [42] <- Index 42
		if(replayMode)
		{
			long proxyDataRecordId =1617042156919L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 974
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [43] <- Index 43
		if(replayMode)
		{
			long proxyDataRecordId =1617042156936L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5746
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [44] <- Index 44
		if(replayMode)
		{
			long proxyDataRecordId =1617042156942L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF2", header text fragment = [verification disabled], recorded content size = 49708
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF2", null, null);		// Test [45] <- Index 45
		if(replayMode)
		{
			long proxyDataRecordId =1617042157104L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/X-ICON", header text fragment = [verification disabled], recorded content size = 1150
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/X-ICON", null, null);		// Test [46] <- Index 46
		if(replayMode)
		{
			long proxyDataRecordId =1617042157447L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4676
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [47] <- Index 47
		if(replayMode)
		{
			long proxyDataRecordId =1617042159636L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 210
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [48] <- Index 48
		if(replayMode)
		{
			long proxyDataRecordId =1617042159658L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_2(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 2 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 443
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [51] <- Index 51
		if(replayMode)
		{
			long proxyDataRecordId =1617042184663L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1723
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [52] <- Index 52
		if(replayMode)
		{
			long proxyDataRecordId =1617042184665L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [53] <- Index 53
		if(replayMode)
		{
			long proxyDataRecordId =1617042184956L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 994
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [54] <- Index 54
		if(replayMode)
		{
			long proxyDataRecordId =1617042184975L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_2(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_2 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 12262
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [55] <- Index 55
		if(replayMode)
		{
			long proxyDataRecordId =1617042184976L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1884
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [56] <- Index 56
		if(replayMode)
		{
			long proxyDataRecordId =1617042184977L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 13432
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [57] <- Index 57
		if(replayMode)
		{
			long proxyDataRecordId =1617042184978L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 986
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [58] <- Index 58
		if(replayMode)
		{
			long proxyDataRecordId =1617042185580L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 618
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [59] <- Index 59
		if(replayMode)
		{
			long proxyDataRecordId =1617042185581L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_3(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 3 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 6891
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [63] <- Index 63
		if(replayMode)
		{
			long proxyDataRecordId =1617042202665L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 5411
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [64] <- Index 64
		if(replayMode)
		{
			long proxyDataRecordId =1617042202667L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1198
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [65] <- Index 65
		if(replayMode)
		{
			long proxyDataRecordId =1617042202682L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1105
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [66] <- Index 66
		if(replayMode)
		{
			long proxyDataRecordId =1617042202692L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1452
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [67] <- Index 67
		if(replayMode)
		{
			long proxyDataRecordId =1617042202693L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2501
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [68] <- Index 68
		if(replayMode)
		{
			long proxyDataRecordId =1617042202694L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 3410
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [69] <- Index 69
		if(replayMode)
		{
			long proxyDataRecordId =1617042203004L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1024
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [70] <- Index 70
		if(replayMode)
		{
			long proxyDataRecordId =1617042203005L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1149
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [71] <- Index 71
		if(replayMode)
		{
			long proxyDataRecordId =1617042203006L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 804
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [72] <- Index 72
		if(replayMode)
		{
			long proxyDataRecordId =1617042203007L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2809
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [73] <- Index 73
		if(replayMode)
		{
			long proxyDataRecordId =1617042203012L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1723
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [74] <- Index 74
		if(replayMode)
		{
			long proxyDataRecordId =1617042203013L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 4604
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [75] <- Index 75
		if(replayMode)
		{
			long proxyDataRecordId =1617042203329L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 895
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [76] <- Index 76
		if(replayMode)
		{
			long proxyDataRecordId =1617042203336L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2773
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [77] <- Index 77
		if(replayMode)
		{
			long proxyDataRecordId =1617042203338L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4232
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [78] <- Index 78
		if(replayMode)
		{
			long proxyDataRecordId =1617042203361L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 930
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [79] <- Index 79
		if(replayMode)
		{
			long proxyDataRecordId =1617042203362L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1145
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [80] <- Index 80
		if(replayMode)
		{
			long proxyDataRecordId =1617042203363L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2184
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [81] <- Index 81
		if(replayMode)
		{
			long proxyDataRecordId =1617042203640L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 265
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [82] <- Index 82
		if(replayMode)
		{
			long proxyDataRecordId =1617042203653L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 5516
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [83] <- Index 83
		if(replayMode)
		{
			long proxyDataRecordId =1617042203654L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 682
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [84] <- Index 84
		if(replayMode)
		{
			long proxyDataRecordId =1617042203657L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1446
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [85] <- Index 85
		if(replayMode)
		{
			long proxyDataRecordId =1617042203658L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1413
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [86] <- Index 86
		if(replayMode)
		{
			long proxyDataRecordId =1617042203959L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 391
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [87] <- Index 87
		if(replayMode)
		{
			long proxyDataRecordId =1617042203968L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 31550
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [88] <- Index 88
		if(replayMode)
		{
			long proxyDataRecordId =1617042203971L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 99593
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [89] <- Index 89
		if(replayMode)
		{
			long proxyDataRecordId =1617042203974L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2173
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [90] <- Index 90
		if(replayMode)
		{
			long proxyDataRecordId =1617042203976L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 853
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [91] <- Index 91
		if(replayMode)
		{
			long proxyDataRecordId =1617042203977L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4841
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [92] <- Index 92
		if(replayMode)
		{
			long proxyDataRecordId =1617042204296L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8553
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [93] <- Index 93
		if(replayMode)
		{
			long proxyDataRecordId =1617042204297L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2496
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [94] <- Index 94
		if(replayMode)
		{
			long proxyDataRecordId =1617042204300L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 994
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [95] <- Index 95
		if(replayMode)
		{
			long proxyDataRecordId =1617042204321L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1171
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [96] <- Index 96
		if(replayMode)
		{
			long proxyDataRecordId =1617042204322L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [97] <- Index 97
		if(replayMode)
		{
			long proxyDataRecordId =1617042204582L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2876
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [98] <- Index 98
		if(replayMode)
		{
			long proxyDataRecordId =1617042204635L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 59092
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [99] <- Index 99
		if(replayMode)
		{
			long proxyDataRecordId =1617042204636L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4301
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [100] <- Index 100
		if(replayMode)
		{
			long proxyDataRecordId =1617042204640L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4664
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [101] <- Index 101
		if(replayMode)
		{
			long proxyDataRecordId =1617042204641L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6078
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [102] <- Index 102
		if(replayMode)
		{
			long proxyDataRecordId =1617042204936L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5746
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [103] <- Index 103
		if(replayMode)
		{
			long proxyDataRecordId =1617042204944L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1985
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [104] <- Index 104
		if(replayMode)
		{
			long proxyDataRecordId =1617042204954L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 33172
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [105] <- Index 105
		if(replayMode)
		{
			long proxyDataRecordId =1617042204957L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_3(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_3 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4934
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [106] <- Index 106
		if(replayMode)
		{
			long proxyDataRecordId =1617042204960L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 781
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [107] <- Index 107
		if(replayMode)
		{
			long proxyDataRecordId =1617042204966L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 23495
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [108] <- Index 108
		if(replayMode)
		{
			long proxyDataRecordId =1617042205206L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1428
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [109] <- Index 109
		if(replayMode)
		{
			long proxyDataRecordId =1617042205210L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 14173
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [110] <- Index 110
		if(replayMode)
		{
			long proxyDataRecordId =1617042205213L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5344
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [111] <- Index 111
		if(replayMode)
		{
			long proxyDataRecordId =1617042205228L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2576
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [112] <- Index 112
		if(replayMode)
		{
			long proxyDataRecordId =1617042205231L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3099
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [113] <- Index 113
		if(replayMode)
		{
			long proxyDataRecordId =1617042205232L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 1969
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "IsoMetrix");		// Test [114] <- Index 114
		if(replayMode)
		{
			long proxyDataRecordId =1617042205528L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/FONT-WOFF2", header text fragment = [verification disabled], recorded content size = 49708
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/FONT-WOFF2", null, null);		// Test [115] <- Index 115
		if(replayMode)
		{
			long proxyDataRecordId =1617042205529L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/HTML", header text fragment = [verification disabled], recorded content size = 502
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/HTML", null, "IsoMetrix");		// Test [117] <- Index 117
		if(replayMode)
		{
			long proxyDataRecordId =1617042205532L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/X-ICON", header text fragment = [verification disabled], recorded content size = 1150
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/X-ICON", null, null);		// Test [118] <- Index 118
		if(replayMode)
		{
			long proxyDataRecordId =1617042205683L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1909
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [119] <- Index 119
		if(replayMode)
		{
			long proxyDataRecordId =1617042205809L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1866
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [120] <- Index 120
		if(replayMode)
		{
			long proxyDataRecordId =1617042205810L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 395
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [121] <- Index 121
		if(replayMode)
		{
			long proxyDataRecordId =1617042205811L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 3409
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [122] <- Index 122
		if(replayMode)
		{
			long proxyDataRecordId =1617042205812L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1067
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [123] <- Index 123
		if(replayMode)
		{
			long proxyDataRecordId =1617042205944L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 187
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [124] <- Index 124
		if(replayMode)
		{
			long proxyDataRecordId =1617042206124L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 37169
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [125] <- Index 125
		if(replayMode)
		{
			long proxyDataRecordId =1617042206132L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 13346
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [126] <- Index 126
		if(replayMode)
		{
			long proxyDataRecordId =1617042206140L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 12625
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [127] <- Index 127
		if(replayMode)
		{
			long proxyDataRecordId =1617042206145L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 634
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [128] <- Index 128
		if(replayMode)
		{
			long proxyDataRecordId =1617042206186L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 6257
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [129] <- Index 129
		if(replayMode)
		{
			long proxyDataRecordId =1617042206340L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 954
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [130] <- Index 130
		if(replayMode)
		{
			long proxyDataRecordId =1617042206400L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 342
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [131] <- Index 131
		if(replayMode)
		{
			long proxyDataRecordId =1617042206662L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3472
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [132] <- Index 132
		if(replayMode)
		{
			long proxyDataRecordId =1617042206679L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 196827
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [133] <- Index 133
		if(replayMode)
		{
			long proxyDataRecordId =1617042206680L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 792205
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [134] <- Index 134
		if(replayMode)
		{
			long proxyDataRecordId =1617042206681L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 22750
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [135] <- Index 135
		if(replayMode)
		{
			long proxyDataRecordId =1617042206684L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 66251
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [136] <- Index 136
		if(replayMode)
		{
			long proxyDataRecordId =1617042206687L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1659
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [137] <- Index 137
		if(replayMode)
		{
			long proxyDataRecordId =1617042206915L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 850
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [138] <- Index 138
		if(replayMode)
		{
			long proxyDataRecordId =1617042206931L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 7015
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [139] <- Index 139
		if(replayMode)
		{
			long proxyDataRecordId =1617042206950L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 13432
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [140] <- Index 140
		if(replayMode)
		{
			long proxyDataRecordId =1617042206953L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 791
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [141] <- Index 141
		if(replayMode)
		{
			long proxyDataRecordId =1617042207165L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 8120
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [142] <- Index 142
		if(replayMode)
		{
			long proxyDataRecordId =1617042207178L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [143] <- Index 143
		if(replayMode)
		{
			long proxyDataRecordId =1617042207191L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1154
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [144] <- Index 144
		if(replayMode)
		{
			long proxyDataRecordId =1617042207193L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 3737
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [145] <- Index 145
		if(replayMode)
		{
			long proxyDataRecordId =1617042207390L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5550
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [146] <- Index 146
		if(replayMode)
		{
			long proxyDataRecordId =1617042207408L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 290
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [147] <- Index 147
		if(replayMode)
		{
			long proxyDataRecordId =1617042207415L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1133
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [148] <- Index 148
		if(replayMode)
		{
			long proxyDataRecordId =1617042207430L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4676
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [149] <- Index 149
		if(replayMode)
		{
			long proxyDataRecordId =1617042210622L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_4(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 4 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [159] <- Index 159
		if(replayMode)
		{
			long proxyDataRecordId =1617042232723L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_4(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_4 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_5(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 5 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_5(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_5 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_6(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 6 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1048
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [165] <- Index 165
		if(replayMode)
		{
			long proxyDataRecordId =1617042267921L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1164
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [166] <- Index 166
		if(replayMode)
		{
			long proxyDataRecordId =1617042268175L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 9034
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [167] <- Index 167
		if(replayMode)
		{
			long proxyDataRecordId =1617042268434L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1279
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [168] <- Index 168
		if(replayMode)
		{
			long proxyDataRecordId =1617042268629L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2234
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [169] <- Index 169
		if(replayMode)
		{
			long proxyDataRecordId =1617042268648L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 1418
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [170] <- Index 170
		if(replayMode)
		{
			long proxyDataRecordId =1617042268672L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 938
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [171] <- Index 171
		if(replayMode)
		{
			long proxyDataRecordId =1617042268698L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 2387
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [172] <- Index 172
		if(replayMode)
		{
			long proxyDataRecordId =1617042268713L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 768
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [173] <- Index 173
		if(replayMode)
		{
			long proxyDataRecordId =1617042268724L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 915
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [174] <- Index 174
		if(replayMode)
		{
			long proxyDataRecordId =1617042268895L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [175] <- Index 175
		if(replayMode)
		{
			long proxyDataRecordId =1617042269216L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 947
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [176] <- Index 176
		if(replayMode)
		{
			long proxyDataRecordId =1617042269260L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 974
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [177] <- Index 177
		if(replayMode)
		{
			long proxyDataRecordId =1617042269269L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1261
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [178] <- Index 178
		if(replayMode)
		{
			long proxyDataRecordId =1617042269286L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4344
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [179] <- Index 179
		if(replayMode)
		{
			long proxyDataRecordId =1617042269287L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 38506
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [180] <- Index 180
		if(replayMode)
		{
			long proxyDataRecordId =1617042269289L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6401
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [181] <- Index 181
		if(replayMode)
		{
			long proxyDataRecordId =1617042269532L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 4589
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [182] <- Index 182
		if(replayMode)
		{
			long proxyDataRecordId =1617042269533L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6178
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [183] <- Index 183
		if(replayMode)
		{
			long proxyDataRecordId =1617042269553L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_6(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_6 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 2622
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [184] <- Index 184
		if(replayMode)
		{
			long proxyDataRecordId =1617042269554L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 681
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [185] <- Index 185
		if(replayMode)
		{
			long proxyDataRecordId =1617042269709L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 948
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [186] <- Index 186
		if(replayMode)
		{
			long proxyDataRecordId =1617042269793L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1170
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [187] <- Index 187
		if(replayMode)
		{
			long proxyDataRecordId =1617042269828L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 11986
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [188] <- Index 188
		if(replayMode)
		{
			long proxyDataRecordId =1617042269829L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6498
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [189] <- Index 189
		if(replayMode)
		{
			long proxyDataRecordId =1617042269830L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 626
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [190] <- Index 190
		if(replayMode)
		{
			long proxyDataRecordId =1617042269831L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 5754
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [191] <- Index 191
		if(replayMode)
		{
			long proxyDataRecordId =1617042269948L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 17474
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [192] <- Index 192
		if(replayMode)
		{
			long proxyDataRecordId =1617042270032L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 85557
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [193] <- Index 193
		if(replayMode)
		{
			long proxyDataRecordId =1617042270071L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 6018
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [194] <- Index 194
		if(replayMode)
		{
			long proxyDataRecordId =1617042270083L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 937
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [195] <- Index 195
		if(replayMode)
		{
			long proxyDataRecordId =1617042270085L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 33682
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "Effective date");		// Test [196] <- Index 196
		if(replayMode)
		{
			long proxyDataRecordId =1617042271074L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 618
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [197] <- Index 197
		if(replayMode)
		{
			long proxyDataRecordId =1617042271087L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 2196
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [198] <- Index 198
		if(replayMode)
		{
			long proxyDataRecordId =1617042271089L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/OCTET-STREAM", header text fragment = [verification disabled], recorded content size = 96144
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/OCTET-STREAM", null, null);		// Test [200] <- Index 200
		if(replayMode)
		{
			long proxyDataRecordId =1617042271757L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 16420
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [201] <- Index 201
		if(replayMode)
		{
			long proxyDataRecordId =1617042271840L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1114
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [202] <- Index 202
		if(replayMode)
		{
			long proxyDataRecordId =1617042271841L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 1140
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [203] <- Index 203
		if(replayMode)
		{
			long proxyDataRecordId =1617042271843L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_7(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 7 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_7(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_7 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_8(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 8 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1985
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"header\":{\"id\":{\"text\":\"");		// Test [209] <- Index 209
		if(replayMode)
		{
			long proxyDataRecordId =1617042304599L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// extract variable(s) from response
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getContentString());

		// setup var extractor for 'C_Timestamp1'
		BoundaryBasedExtractorItem boundaryBasedContentExtractorItem0209_1 = new BoundaryBasedExtractorItem( ",\"dv\":{\"text\":\"" , "\",\"items\":null},\"instanceid\":{\"text",1,false,false,0,false);
		boundaryBasedExtractor.addBoundaryBasedExtractorItem(boundaryBasedContentExtractorItem0209_1);

		boundaryBasedExtractor.extractText();
		boundaryBasedExtractor = new BoundaryBasedExtractor(testURL.getHeaderString());

		boundaryBasedExtractor.extractText();
		try
		{
			// extract var 'C_Timestamp1'
			C_Timestamp1 = boundaryBasedContentExtractorItem0209_1.getResultText();
			log("<<< C_Timestamp1 = " + C_Timestamp1);
			// Replace the value of a variable with a user given value in case of a blank text extracted during the load test
			if (false && C_Timestamp1!= null && C_Timestamp1.trim().length() == 0)
			{
				C_Timestamp1 = "";
				log("runtime note: the extraction of a new value for the variable 'C_Timestamp1' ends up with an empty string - a substitute value was set");
				log("<<< C_Timestamp1 = " + C_Timestamp1);
			}
		}
		catch (Exception e) { C_Timestamp1 = null; log(e); }
		if (C_Timestamp1 == null)
		{
			// failure - dump wrong response content and abort current outer loop - after that start next loop
			String errorText = "*** error: unable to extract var 'C_Timestamp1' from boundary based pattern";
			log(errorText);
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			threadStep = performanceData.setFailed(threadStep, HttpTestURL.STATUS_TYPE_USER_SPECIFIC_TEST_FAILED, errorText, testURL, this);
		
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_8(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_8 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 5329
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [210] <- Index 210
		if(replayMode)
		{
			long proxyDataRecordId =1617042305302L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_9(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 9 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "IMAGE/PNG", header text fragment = [verification disabled], recorded content size = 965
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "IMAGE/PNG", null, null);		// Test [217] <- Index 217
		if(replayMode)
		{
			long proxyDataRecordId =1617042331611L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_9(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_9 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 2100
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "Región de Tarapacá -");		// Test [218] <- Index 218
		if(replayMode)
		{
			long proxyDataRecordId =1617042331698L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1718141
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "Send record back to Gather information and make recommendations stage");		// Test [219] <- Index 219
		if(replayMode)
		{
			long proxyDataRecordId =1617042332332L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_10(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 10 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "TEXT/CSS", header text fragment = [verification disabled], recorded content size = 191
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "TEXT/CSS", null, null);		// Test [225] <- Index 225
		if(replayMode)
		{
			long proxyDataRecordId =1617042357222L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_10(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_10 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 6715
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "Región de Tarapacá -");		// Test [227] <- Index 227
		if(replayMode)
		{
			long proxyDataRecordId =1617042357724L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_11(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 11 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_11(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_11 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_12(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 12 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JSON", header text fragment = [verification disabled], recorded content size = 1988
		// content test algorithm: search text
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JSON", null, "{\"header\":{\"id\":{\"text\":\"");		// Test [239] <- Index 239
		if(replayMode)
		{
			long proxyDataRecordId =1617042405353L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure - dump wrong content to thread log and abort current loop
			terminateFailedUser(testURL);		// set the user to be terminated at end of loop ? - only performed if the URL call has marked before to support that !
			endOfExecuteLoop(false, testURL, threadStep, loopPluginContext);
			return false;
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_12(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_12 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_13(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 13 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		if (!writeHttpAsyncResponseTabOutput_13(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_13 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		return true;		// end of asynch response checks for this page
	}



	boolean synchResponsesParallelRequestsPage_14(int totalLoopCounter, LoadtestPluginContext loopPluginContext, InnerLoopContext innerLoopContext, Object httpLogVectorObject) throws Exception
	{
		int lastThreadStepInMainThread = threadStep;		// save last executed thread step
		
		// wait for the response of all parallel requests
		threadStep = pageThreadHandler.getLastThreadStep();
		pageThreadHandler.waitForSynch();
		log("Page 14 Time = " + pageThreadHandler.getPageTime() + " ms");
		
		
		threadStep = pageThreadHandler.getFirstThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/X-JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 47706
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/X-JAVASCRIPT", null, null);		// Test [248] <- Index 248
		if(replayMode)
		{
			long proxyDataRecordId =1617042442419L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		if (!writeHttpAsyncResponseTabOutput_14(loopPluginContext,lastThreadStepInMainThread))
			return false;
		
		// all done
		threadStep = lastThreadStepInMainThread;		// restore last executed thread step
		return true;		// end of asynch response checks for this page
	}
	
	
	private boolean writeHttpAsyncResponseTabOutput_14 (LoadtestPluginContext loopPluginContext, int lastThreadStepInMainThread ) throws Exception
	{
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 582
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [249] <- Index 249
		if(replayMode)
		{
			long proxyDataRecordId =1617042442433L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		threadStep = pageThreadHandler.getNextThreadStep();
		if (threadStep == -1)
		{
			log("[" + threadStep + "] asynch request not executed - loop aborted by checking the result of previous request");
			threadStep = lastThreadStepInMainThread;		// restore last executed thread step
			return true;
		}
		testURL = pageThreadHandler.getHttpTestURL(threadStep);
		log("[" + threadStep + "] check response of asynch request " + testURL.getRequestInfoText() + " ...");
		log("   " + testURL.getShortResultText());

		// verify response: status code = 200, content type = "APPLICATION/JAVASCRIPT", header text fragment = [verification disabled], recorded content size = 1089
		// content test algorithm: none - no content check
		urlCallPassed = httpResponseOk(testURL, threadStep, new int[] {200}, "APPLICATION/JAVASCRIPT", null, null);		// Test [250] <- Index 250
		if(replayMode)
		{
			long proxyDataRecordId =1617042443127L;
			createReplaySnapShotRecord(threadLoopCounter, proxyDataRecordId, testURL, replaySnapShotsDump);
		}
		if (!urlCallPassed)
		{
			// failure but continue current loop: mark pending transactions as defective and dump URL content to thread log
			transactionHandler.setPendingTransactionsAsDefective();
			log(testURL);
		}
		if (debugContent && urlCallPassed)
			log(testURL);

		// update performance data if url call passed
		if (urlCallPassed)
			threadStep = setPassed(performanceData, threadStep, testURL);
		else
			threadStep = threadStep + 1;		// url call failed - performance data already updated


		
		return true;		// end of asynch response checks for this page
	}



	/**
	 * implement GetRealTimeUserInputFieldsInterface: get the definition and the value of all real-time user input fields.
	 */
	public ArrayList<RealTimeUserInputField> getRealTimeUserInputFields()
	{
		try
		{
			ArrayList<RealTimeUserInputField> realTimeUserInputFieldList = new ArrayList<RealTimeUserInputField>();
			return realTimeUserInputFieldList;
		}
		catch (Exception e)
		{
			log(e);
			return null;
		}
	}



	/**
	 * implement ThreadStepInterface: get the current execution step (current URL call or page break) of a simulated user.
	 */
	public int getExecutionStep()
	{
		return threadStep;
	}



	/**
	 * implement SetThreadStepInterface: set the current execution step (current URL call or page break) of a simulated user.
	 */
	public void setExecutionStep(int threadStep)
	{
		this.threadStep = threadStep;
	}



	/**
	 * implement SSLSessionCacheStatisticInterface: get statistic data about the SSL session cache behavior of a simulated user.
	 */
	public SSLSessionCacheStatistic getSSLSessionCacheStatistic()
	{
		return sslStatistic;
	}



	/**
	 * implement VaryingTestDurationInterface: support to extend or to reduce the planned test duration.
	 */
	public int getPlannedTestDuration()
	{
		return plannedTestDuration;
	}
	
	public void setExtendTestDuration(int deltaSeconds)
	{
		if (plannedTestDuration == 0)
		{
			plannedTestDuration = deltaSeconds;		// the old planned test duration was unlimited but is now limited
			return;
		}
		if (deltaSeconds == 0)
		{
			plannedTestDuration = 0;		// the new planned test duration is now unlimited
			return;
		}
		plannedTestDuration = plannedTestDuration + deltaSeconds;
	}



	/**
	 * implement SuspendResumeInterface: support to suspend and to resume the test execution.
	 */
	public int getPlannedStartupDelay()
	{
		return plannedStartupDelay;
	}
	
	public void setUserResumeStartWaitDelay(int millis)
	{
		userResumeStartWaitDelay = millis;
	}



	/**
	 * implement VaryingLoadInterface: support to decrement the number of simulated users at runtime.
	 */
	public void setDecrementEndOfLoopFlag(boolean decrementEndOfLoopFlag)
	{
		this.decrementEndOfLoopFlag = decrementEndOfLoopFlag;
	}

	public boolean isDecrementEndOfLoopFlag()
	{
		return decrementEndOfLoopFlag;
	}



	/**
	 * internal method: execute the loops for one simulated user as a thread.
	 * controls the thread and displays the (thread-)log if one loop has been completed.
	 */
	public void run()
	{
		// user terminated by inline script, at start of user ?
		if (isTerminateUser())
		{
			System.out.println("# --- thread " + Thread.currentThread().getName() + " aborted --- " + ZoneTime.dateToShortString() + " ---");
			return;
		}
		try
		{
			while (true)
			{
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				clearLog();
				
				// execute loop
				log("--- loop started --- " + ZoneTime.dateToShortString() + " ---");
				long loopStartTime = System.nanoTime();
				if(replayMode)
				{
					createReplaySnapShot(threadLoopCounter, replaySnapShotsDump);
				}
				boolean loopPassed = this.execute(totalLoopCounter.getAndIncrement());
				performanceData.addUserTransactionMeasuredSamples(transactionHandler.getPendingTransactions());
				ArrayList<UserTransactionContext> nonExecutedTransactions = transactionHandler.getNotExecutedTransactions();

				for (UserTransactionContext nonExecutedTransaction : new ArrayList<>(nonExecutedTransactions))
				{
					if(transactionContextMap.containsKey(nonExecutedTransaction.getTransactionId()+"") && transactionContextMap.get(nonExecutedTransaction.getTransactionId()+"") == null)
					{
						transactionContextMap.remove(nonExecutedTransaction.getTransactionId()+"");
						nonExecutedTransactions.remove(nonExecutedTransaction);
					}
				}

				performanceData.addUserTransactionNotExecutedSamples(nonExecutedTransactions);
				performanceData.addSocktPoolStatistic(socketPool);
				socketPool.closePool();
				performanceData.addSSLCacheStatistic(sslStatistic.getSSLSessionCacheStatisticResult());
				sslStatistic.reset();
				
				// eof of input file ?
				if (abortedByEofInputFile())
					return;		// endOfRun() not called in such a case
				
				// check loop result
				String remainingLoopInfo = "";
				if (checkLoopCount)
					remainingLoopInfo = " [remaining loops = " + (remainingLoops - 1) + "]";
				if (loopPassed)
				{
					performanceData.addPassedLoop();
					log("--- loop passed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				else
				{
					performanceData.addFailedLoop();
					log("--- loop failed ---  " + ZoneTime.dateToShortString() + " ---" + remainingLoopInfo);
				}
				threadStep = ThreadStepInterface.THREAD_NO_STEP;
				
				// display thread log to standard output
				if (debugLoops || (debugFailedLoops && (!loopPassed)))
				{
					synchronized (dumpLock)
					{
						dumpLog(System.out);				// full log
					}
				}
				
				// check if max loops reached
				if (checkLoopCount)
				{
					// all done ?
					remainingLoops--;
					if (remainingLoops <= 0)
					{
						endOfRun();
						return;
					}
				}
				
				// check if simulated user must be decremented
				if (decrementEndOfLoopFlag && (getOwnLoadTestUserContext().getDecrementEndOfLoopPointInTime() <= System.currentTimeMillis()))
				{
					return;
				}
				
				// check if max test duration reached
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					endOfRun();
					return;
				}
				
				// check if this specific user is terminated earlier than planned by a HTTP content verification or by a plug-in
				if (isTerminateUser())
				{
					endOfRun();
					System.out.println("# --- thread " + Thread.currentThread().getName() + " terminate failed user --- " + ZoneTime.dateToShortString() + " ---");
					return;
				}
				
				// check if load test execution is temporary suspended
				boolean wasSuspended = false;
				while (isSuspend())
				{
					wasSuspended = true;
					try { Thread.currentThread().sleep(20); } catch (InterruptedException ie) {}
					if (abortedByRemote() || abortedByEofInputFile())
					{
						endOfRun();
						return;
					}
					
					// check if max test duration reached during suspend
					if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					{
						endOfRun();
						return;
					}
				}
				// check if load test execution is resumed
				if (wasSuspended)
				{
					try { sleepRemoteInterruptable(userResumeStartWaitDelay); } catch (InterruptedException ie) {}
				}
				
				// wait 20 milliseconds if loop has failed
				if (!loopPassed)
					try { Thread.currentThread().sleep(loopErrorDelay); } catch (InterruptedException ie) {}
				
				// enable pacing for the loop
				if(pacing > 0)
				{
					long loopElaspedTime = (System.nanoTime() - loopStartTime) / 1000000l;
					long loopPacingValue = Long.valueOf(pacing).longValue() * 1000l;
					if (loopElaspedTime < loopPacingValue)
					{
						threadStep = threadStep - 1;
						log(" - loop pacing: sleeping for "+ (loopPacingValue - loopElaspedTime)+" ms ...");
						Thread.currentThread().sleep(loopPacingValue - loopElaspedTime);
						threadStep++;
					}
				}
				// execute next loop
				threadLoopCounter++;
			}	// end: while (true)
		}
		catch (Throwable tex)
		{
			log("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
			log(tex);
			log();
			synchronized (dumpLock)
			{
				if(replayMode)
				{
					saveReplaySnapShots("ZTReplay.snapshot");
				}
				dumpLog(System.out);				// full log
				System.err.println("*** INTERNAL ERROR / LOAD TEST ABORTED ***");
				tex.printStackTrace(System.err);
				System.exit(-2);
			}
		}
		finally
		{
			// remove the reference to this load test instance and the reference to the thread that runs this instance
			try
			{
				if (!decrementEndOfLoopFlag)
				{
					getUserContextTable().getWriteLock().lock();
					getOwnLoadTestUserContext().setLoadTestUserFinallyEnded();
					getUserContextTable().getWriteLock().unlock();
				}
				else
					decrementEndOfLoopFlag = false;
			}
			catch (Throwable texFinal)
			{
				System.err.println("*** INTERNAL FINALLY ERROR / LOAD TEST ABORTED ***");
				texFinal.printStackTrace(System.err);
				System.exit(-2);
			}
		}
	}



	/**
	 * internal method: called when a user has completed the test-run.
	 */
	public void endOfRun()
	{
		clearLog();
		
		if (debugLoops && (getLog().size() > 0))
		{
			synchronized (dumpLock)
			{
				dumpLog(System.out);		// dump log of inline scripts and load test plug-ins which are executed at end of user
			}
		}
	}



	/**
	 * Main program. Starts the test and waits until all have been done.
	 */
	public static void main(String[] args)
	{
		// check command line argument -h or -help
		if ((ParseArgs.hasOption(args, "-h")) || (ParseArgs.hasOption(args, "-help")))
		{
			System.out.println();
			System.out.println("Help - Proxy Sniffer Load Test Program:");
			System.out.println();
			System.out.println("-u <number>              ->> required argument: number of concurrent users");
			System.out.println("-d <seconds>             ->> required argument: planned test duration in seconds (default: 30, 0 = unlimited)");
			System.out.println("-t <seconds>             ->> required argument: request timeout per url in seconds");
			System.out.println();
			System.out.println("-tconnect <seconds>      ->> TCP/IP socket connect timeout in seconds (default: use value of -t <seconds>)");
			System.out.println();
			System.out.println("-sdelay <milliseconds>   ->> startup delay time between concurrent users in milliseconds (default: 200)");
			System.out.println("-mtpu <number>           ->> maximum number of parallel threads per user (default: " + MAX_PARALLEL_THREADS_PER_USER + ")");
			System.out.println("-maxloops <number>       ->> maximum number of loops per user (default: 0 = unlimited)");
			System.out.println("-pacing <seconds>        ->> sets a minimum time for all in the loop executed page breaks and url calls which must be elapsed before the next loop starts (default: 0 = no pacing)");
			System.out.println("-downlink <kbps>         ->> maximum downlink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-uplink <kbps>           ->> maximum uplink network bandwidth per user in kilobits per second (default: 0 = unlimited)");
			System.out.println("-multihomed <filename>   ->> use serveral client ip addresses - file format: <addr1>, <addr2>, ... (all on the same line)");
			System.out.println("-sampling <seconds>      ->> statistic sampling interval in seconds (default: 15)");
			System.out.println("-percpage <percent>      ->> additional sampling rate per web page call in percent (default: 100)");
			System.out.println("-percurl <percent>       ->> additional sampling rate per url call in percent (default: 0)");
			System.out.println("-percurlopt <level>      ->> extended sampling level per url call, see application reference manual (default: 0 = disabled)");
			System.out.println("-maxerrsnap <number>     ->> maximum number of error snapshots per url (default: 0 = unlimited)");
			System.out.println("-maxerrmem <megabytes>   ->> maximum size of memory in megabytes which can be used for error snapshots (default: 20, -1 = unlimited)");
			System.out.println("-nosdelayCluster         ->> apply startup delay time between concurrent users per exec agent, but not per cluster job (default: apply per cluster job)");
			System.out.println("-setuseragent \"<text>\"   ->> replace the recorded value of the HTTP request header field User-Agent with a new value");
			System.out.println("-collect <host>[:<port>] ->> collect additional data from external measuring agents (data collectors)");
			System.out.println("-res <filename>          ->> overrides the default name of the binary output file");
			System.out.println("-nores                   ->> disables to create the binary output file");
			System.out.println();
			System.out.println("-ssl <version>           ->> set SSL version: possible options are \"all\" (default), \"v3\", \"tls\", \"tls11\" or \"tls12\"");
			System.out.println("-sslcache <seconds>      ->> timeout of user-related SSL session cache (default: 300, 0 = cache disabled)");
			System.out.println("-sslrandom <type>        ->> set the type of the random generator used for SSL handshakes: possible options are \"fast\", \"iaik\" (default) or \"java\"");
			System.out.println("-sslcmode                ->> apply SSL/HTTPS compatibility workarounds for deficient SSL servers");
			System.out.println("-noECC                   ->> disable support of elliptic curve cryptography (ECC)");
			System.out.println("-nosni                   ->> disable support of server name indication (SNI)");
			System.out.println("-snicritical             ->> set the TLS SNI extension as critical (default: non-critical)");
			System.out.println("-tlssessiontickets       ->> set the TLS to use Session Tickets (non-critical)");
			System.out.println("-iaikLast                ->> adds the IAIK security provider at the last position (instead of default: IAIK at first position)");
			System.out.println();
			System.out.println("-dnssrv <IP-1>[,IP-N])   ->> use specific DNS server(s) to resolve DNS host names (default: use OS to resolve host names)");
			System.out.println("-dnshosts <filename>     ->> use specific DNS hosts file (default: use OS to resolve host names)");
			System.out.println("-dnstranslation <filename> ->> use a DNS translation file that converts DNS names. It might be needed to disable TLS SNI if this option is used");
			System.out.println("-dnsenattl               ->> enable consideration of DNS TTL by using the received TTL-values from the DNS Server(s) (default: TTL disabled)");
			System.out.println("-dnsfixttl <seconds>     ->> enable DNS TTL by using a fixed TTL-value of seconds for all DNS resolves");
			System.out.println("-dnsperloop              ->> perform new DNS resolves for each executed loop. All resolves are stable within the same loop (no consideration of DNS TTL within a loop)");
			System.out.println("-dnsstatistic            ->> collect statistical data about DNS resolutions. Note: use this option only if not any other, more specific DNS option is enabled");
			System.out.println("-dnsdebug                ->> debug DNS resolves and the DNS cache");
			System.out.println("-enableIPv6 <networkinterface-name>  ->> enable only IPv6 support for recording, also can provide the IPv6 network interface of the load generator");
			System.out.println("-enableIPv6v4 <networkinterface-name> ->> enable both IPv6 and IPv4 (first will try with IPv6 ,if fails will try with IPv4 support for recording),also can provide the IPv6 network interface of the load generator");
			System.out.println();
			System.out.println("-dfl                     ->> debug execution steps of all failed loops to standard output");
			System.out.println("-dl                      ->> debug execution steps of all loops to standard output");
			System.out.println("-dh                      ->> debug HTTP protocol headers to standard output, includes the -dl option");
			System.out.println("-dc                      ->> debug HTTP content data to standard output, includes the -dl option");
			System.out.println("-dhc                     ->> debug HTTP protocol headers and HTTP content data to standard output, includes the -dl option");
			System.out.println("-dC                      ->> debug cookies to standard output, includes the -dl option");
			System.out.println("-dK                      ->> debug keep-alive (socket pool) to standard output, includes the -dl option");
			System.out.println("-dssl                    ->> debug SSL handshake (https) to standard output, includes the -dl and the -dK option");
			System.out.println();
			System.out.println("-tz <timezone>           ->> set time zone (see Application Reference Manual: supported time zones)");
			System.out.println("-dgs a|c                 ->> set number format (decimal group separator) a = '  c = ,");
			System.out.println("-browserlang <text>      ->> set the browser language for the test");
			System.out.println("-enablebrowcache         ->> set the browser cache mode on");
			System.out.println("-checknewpageversion     ->> set the conditional GET mode on");
			System.out.println("-replay                  ->> Indicates the replay mode");
			System.out.println("-annotation <text>       ->> adds an annotation for this test run");
			System.out.println();
			System.out.println("-execAgentHost <ip address or dns name>      ->> set the ip address or the dns name of the exec agent from which the license is used (default: 127.0.0.1)");
			System.out.println("-execAgentPort <port>                        ->> set the tcp/ip port of the exec agent (default: 7993)");
			System.out.println("-execAgentProtocol <plain | http | https>    ->> set the protocol of the exec agent (default: plain)");
			System.out.println("-execAgentUsername <string>                  ->> set the auth. username for the exec agent (default: [no username])");
			System.out.println("-execAgentPassword <string>                  ->> set the auth. password for the exec agent (default: [no password])");
			System.out.println();
			System.out.println("-h                       ->> display this help text");
			System.out.println("-help                    ->> display this help text");
			System.out.println();
			System.exit(-1);
		}
		
		System.out.println("+----------------------------------------------------------------+");
		System.out.println("| Welcome to the ZebraTester Load Test Program.                  |");
		System.out.println("| Additional help available with program argument \"-help\"        |");
		System.out.println("| Procedure Copyright by Apica. |");
		System.out.println("| All rights reserved.             |");
		System.out.println("+----------------------------------------------------------------+");
		
		
		if (commonNextProxyConfig != null)
		{
			System.out.println();
			System.out.println("*** Warning: Loadtest over HTTP(S) Proxy ***");
		}
		
		// check command line argument -noECC
		sslECC = (!ParseArgs.hasOption(args, "-noECC"));       // disable ssl ecc ?
		
		// initialize ssl/https support
		SSLInit.execute(!ParseArgs.hasOption(args, "-iaikLast"), true);
		if (sslECC)
			SSLInit.enableECC();
		
		// check command line argument -nosni
		if (ParseArgs.hasOption(args, "-nosni"))            // disable ssl sni ?
			sslSNI = false;
		
		// check command line argument -snicritical
		if (ParseArgs.hasOption(args, "-snicritical"))      // set ssl sni as critical tls extension ?
			sslSNICirical = true;
		
		// check command line argument -tlssessiontickets
		if (ParseArgs.hasOption(args, "-tlssessiontickets"))      // set tls extension session tickets?
			useTlsSessionTickets = true;
		
		// set default character set for response content tests
		setCharEncoding(prxCharEncoding);
		
		// check command line argument -tz <timezone>
		String timeZoneString = ParseArgs.getString(args, "-tz");
		if (timeZoneString != null)
			defaultTimeZone = timeZoneString.toUpperCase(); // set time zone?
		ZoneTime.setDefaultTimeZone(defaultTimeZone);
		
		// check command line argument -dgs a|c
		String dgs = ParseArgs.getString(args, "-dgs");
		if (dgs != null)
		{
			if (dgs.equalsIgnoreCase("a"))
				defaultNumberGroupingSeparator = '\'';
			if (dgs.equalsIgnoreCase("c"))
				defaultNumberGroupingSeparator = ',';
		}
		Lib.setDefaultNumberGroupingSeparator(defaultNumberGroupingSeparator);
		
		// check command line argument -browserlang <text>
		browserLanguage = ParseArgs.getString(args, "-browserlang");
		
		// check command line argument -enablebrowcache
		if (ParseArgs.hasOption(args, "-enablebrowcache"))
		{
			enableBrowserCache = true;
		}
		
		// check command line argument -checknewpageversion
		if (ParseArgs.hasOption(args, "-checknewpageversion"))
		{
			conditionalGet = true;
		}
		
		// check command line argument -replay
		if (ParseArgs.hasOption(args, "-replay"))
		{
			replayMode = true;
		}
		
		// check command line argument -annotation <text>
		String testRunAnnotation = ParseArgs.getString(args, "-annotation");
		if (testRunAnnotation != null)
		{
			if (testRunAnnotation.startsWith("\"") && testRunAnnotation.endsWith("\""))
				testRunAnnotation = testRunAnnotation.substring(1, testRunAnnotation.length() - 1);
		}
		
		// check command line argument -ssl
		String newSslProtocolVersion = ParseArgs.getString(args, "-ssl");
		if (newSslProtocolVersion != null)
		{
			if (newSslProtocolVersion.equalsIgnoreCase("v2"))
				sslProtocolVersion = "v2";
			if (newSslProtocolVersion.equalsIgnoreCase("v3"))
				sslProtocolVersion = "v3";
			if (newSslProtocolVersion.equalsIgnoreCase("tls"))
				sslProtocolVersion = "tls";
			if (newSslProtocolVersion.equalsIgnoreCase("tls11"))
				sslProtocolVersion = "tls11";
			if (newSslProtocolVersion.equalsIgnoreCase("tls12"))
				sslProtocolVersion = "tls12";
		}
		
		// check command line argument -sslcache <seconds>
		Integer newSslSessionCacheTimeout = ParseArgs.getInteger(args, "-sslcache");
		if (newSslSessionCacheTimeout != null)
			sslSessionCacheTimeout = newSslSessionCacheTimeout.intValue();
		
		// check command line argument -sslrandom
		String sslHandshakeRandomGeneratorTypeStr = ParseArgs.getString(args, "-sslrandom");
		if (sslHandshakeRandomGeneratorTypeStr != null)
		{
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("java"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_JAVA_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("iaik"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_IAIK_DEFAULT;
			if (sslHandshakeRandomGeneratorTypeStr.equalsIgnoreCase("fast"))
				sslHandshakeRandomGeneratorType = HttpSocketPool.SSL_HANDSHAKE_RANDOM_GENERATOR_TYPE_FAST;
		}
		
		// check command line argument -sslcmode
		sslcmode = ParseArgs.hasOption(args, "-sslcmode");  // enable ssl/https compatibility workarounds?
		
		// check command line argument -dfl
		debugFailedLoops = ParseArgs.hasOption(args, "-dfl"); // debug failed loops?
		
		// check command line argument -dl
		debugLoops = ParseArgs.hasOption(args, "-dl");      // debug loops?
		
		// check command line argument -dh
		debugHttp = ParseArgs.hasOption(args, "-dh");       // debug http?
		if (debugHttp)
			debugLoops = true;
		
		// check command line argument -dc
		debugContent = ParseArgs.hasOption(args, "-dc");    // debug content?
		if (debugContent)
			debugLoops = true;
		
		// check command line argument -dhc
		if (ParseArgs.hasOption(args, "-dhc"))				// debug http and content
		{
			debugLoops = true;
			debugHttp = true;
			debugContent = true;
		}
		
		// check command line argument -dC
		debugCookies = ParseArgs.hasOption(args, "-dC");    // debug cookies?
		if (debugCookies)
			debugLoops = true;
		
		// check command line argument -dK
		debugKeepAlive = ParseArgs.hasOption(args, "-dK");  // debug keep.alive (socket pool)?
		if (debugKeepAlive)
			debugLoops = true;
		
		// check command line argument -dssl
		debugSsl = ParseArgs.hasOption(args, "-dssl");      // debug keep.alive (socket pool)?
		if (debugSsl)
		{
			debugLoops = true;
			debugKeepAlive = true;
		}
		
		// get startup delay
		Integer newStartupDelay = ParseArgs.getInteger(args, "-sdelay");
		if (newStartupDelay != null)
			plannedStartupDelay = newStartupDelay.intValue();
		
		// get max. parallel threads per user - note: only valid if CONTAINS_PARALLEL_EXECUTED_URLS = true
		Integer newMaxParallelThreadsPerUser = ParseArgs.getInteger(args, "-mtpu");
		if (newMaxParallelThreadsPerUser != null)
		{
			if (newMaxParallelThreadsPerUser.intValue() > 0)
				maxParallelThreadsPerUser = newMaxParallelThreadsPerUser.intValue();
		}
		// get maximum number of loops per user
		maxPlannedLoops = 0;  // maximum loops per user, 0 = unlimited
		Integer newLoops = ParseArgs.getInteger(args, "-maxloops");
		if (newLoops != null)
			maxPlannedLoops = newLoops.intValue();
		
		// pacing of loops per user
		Integer pacingObj = ParseArgs.getInteger(args, "-pacing");
		if (pacingObj != null)
			pacing = pacingObj.intValue();
		
		// get maximum downlink network bandwidth per user (default = unlimited)
		Integer newDownlinkBandwidth = ParseArgs.getInteger(args, "-downlink");
		if (newDownlinkBandwidth != null)
			downlinkBandwidth = newDownlinkBandwidth.intValue();
		
		// get maximum uplink network bandwidth per user (default = unlimited)
		Integer newUplinkBandwidth = ParseArgs.getInteger(args, "-uplink");
		if (newUplinkBandwidth != null)
			uplinkBandwidth = newUplinkBandwidth.intValue();
		
		// get statistic sampling interval
		int samplingInterval = 15;  // statistic sampling interval in seconds
		Integer newSamplingInterval = ParseArgs.getInteger(args, "-sampling");
		if (newSamplingInterval != null)
			samplingInterval = newSamplingInterval.intValue();
		
		// get additional sampling rate per web page call
		int percentilePageSampling = 100;  // additional sampling rate per web page call in percent
		Integer newPercentilePageSampling = ParseArgs.getInteger(args, "-percpage");
		if (newPercentilePageSampling != null)
			percentilePageSampling = newPercentilePageSampling.intValue();
		
		// get additional sampling rate per url call
		int percentileUrlSampling = 0;  // additional sampling rate per url call in percent
		Integer newPercentileUrlSampling = ParseArgs.getInteger(args, "-percurl");
		if (newPercentileUrlSampling != null)
			percentileUrlSampling = newPercentileUrlSampling.intValue();
		
		// get extended sampling level per url call
		int percentileUrlSamplingAddOption = 0;  // extended sampling level per url call, 0 = disabled
		Integer newPercentileUrlSamplingAddOption = ParseArgs.getInteger(args, "-percurlopt");
		if (newPercentileUrlSamplingAddOption != null)
			percentileUrlSamplingAddOption = newPercentileUrlSamplingAddOption.intValue();
		
		// get maximum number of error snapshots per URL (0 = unlimited)
		int maxErrorSnapshots = 0;
		Integer newMaxErrorSnapshots = ParseArgs.getInteger(args, "-maxerrsnap");
		if (newMaxErrorSnapshots != null)
			maxErrorSnapshots = newMaxErrorSnapshots.intValue();
		
		// get maximum memory in megabytes which can be used for error snapshots (-1 = unlimited, default = 10)
		long maxErrorSnapshotMemory = 20;
		Long newMaxErrorSnapshotMemory = ParseArgs.getLong(args, "-maxerrmem");
		if (newMaxErrorSnapshotMemory != null)
			maxErrorSnapshotMemory = newMaxErrorSnapshotMemory.longValue();
		
		// single user mode ?
		boolean singleUserMode = ParseArgs.hasOption(args, "-singleuser");
		
		// override value for http user agent field ?
		String setUserAgentStr = ParseArgs.getIgnoreCaseString(args, "-setuseragent");
		if (setUserAgentStr != null)
		{
			USER_AGENT_1 = setUserAgentStr;
		}
		// get required input arguments
		int concurrentUsers = 0;     // number of concurrent users
		plannedRequestTimeout = 0;   // request timeout in seconds
		
		System.out.println();
		
		// parse -u argument or ask --> <number of concurrent users>
		Integer i = ParseArgs.getIntegerOrAsk(args, "-u", "Concurrent Users, <RETURN>=1 : ", new Integer(1));
		if (i == null)
			System.exit(-1);
		else
			concurrentUsers = i.intValue();
		
		// parse -d argument or ask --> <test duration in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-d", "Test Duration in Seconds, <RETURN>=30 : ", new Integer(30));
		if (i == null)
			System.exit(-1);
		else
			plannedTestDuration = i.intValue();
		
		// parse -t argument or ask --> <request timeout in seconds>
		i = ParseArgs.getIntegerOrAsk(args, "-t", "HTTP Request Timeout per URL in Seconds, <RETURN>=60 : ", new Integer(60));
		if (i == null)
			System.exit(-1);
		else
			plannedRequestTimeout = i.intValue();
		
		// parse optional -tconnect argument (TCP/IP socket connect timeout in seconds)
		i = ParseArgs.getInteger(args, "-tconnect");
		if (i != null)
			plannedConnectTimeout = i.intValue();
		
		String genericFileName = PerformanceData.proposeFileName("OpenObligation_LT", concurrentUsers, ParseArgs.getString(args, "-executionPlan"));
		
		// auto-configure binary result file
		if (!ParseArgs.hasOption(args, "-nores"))
		{
			String newResultFile = ParseArgs.getString(args, "-res");
			if (newResultFile == null)
				resultFile = genericFileName + ".prxres";
			else
				resultFile = newResultFile;
			System.out.println("Result File : " + resultFile);
		}
		
		// display common arguments at console output
		System.out.println();
		System.out.println("# concurrent users = " + concurrentUsers);
		System.out.println("# max. parallel threads per user = " + maxParallelThreadsPerUser);
		System.out.print("# planned test duration = ");
		if (plannedTestDuration == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + plannedTestDuration + " seconds");
		System.out.println("# http request timeout = " + plannedRequestTimeout + " seconds");
		if (plannedConnectTimeout != 0)
			System.out.println("# tcp/ip socket connect timeout = " + plannedConnectTimeout + " seconds");
		System.out.println("# startup delay = " + plannedStartupDelay + " milliseconds");
		System.out.println("# statistic sampling interval = " + samplingInterval + " seconds");
		System.out.println("# additional sampling rate per web page call = " + percentilePageSampling + " %");
		System.out.println("# additional sampling rate per url call = " + percentileUrlSampling + " %");
		System.out.println("# extended sampling per url call = " + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase());
		System.out.print("# max loops per user = ");
		if (maxPlannedLoops == 0)
			System.out.println("unlimited");
		else
			System.out.println("" + maxPlannedLoops + " loops");
		System.out.print("# pacing for loops = ");
		if (pacing == 0)
			System.out.println("no pacing");
		else
			System.out.println("" + pacing + " seconds");
		if (downlinkBandwidth > 0)
			System.out.println("# max downlink bandwidth per user = " + downlinkBandwidth + " kbps");
		if (uplinkBandwidth > 0)
			System.out.println("# max uplink bandwidth per user = " + uplinkBandwidth + " kbps");
		System.out.println("# http protocol version = v" + httpProtocolVersion);
		System.out.println("# ssl protocol version = " + sslProtocolVersion);
		if (sslSessionCacheTimeout != 0)
			System.out.println("# ssl session cache timeout = " + sslSessionCacheTimeout + " seconds");
		else
			System.out.println("# ssl session cache disabled");
		if (resultFile != null)
			System.out.println("# result file = " + resultFile);
		else
			System.out.println("# no result file");
		if (debugFailedLoops)
			System.out.println("# debug failed loops");
		if (debugLoops)
			System.out.println("# debug loops");
		if (debugHttp)
			System.out.println("# debug http protocol headers");
		if (debugContent)
			System.out.println("# debug http content data");
		if (debugCookies)
			System.out.println("# debug cookies");
		if (debugKeepAlive)
			System.out.println("# debug keep-alive (socket pool)");
		if (debugSsl)
			System.out.println("# debug ssl (https)");
		
		
		// ----------------------------
		// *** initialize load test ***
		// ----------------------------
		
		
		// initialize performance data
		// ---------------------------
		final int PAGE_BREAKS = 14;  // number of page breaks in execute()  - modify this value if you add or delete some page breaks
		final int MAX_THREAD_STEPS = 237;  // number of URL requests in execute() - modify this value if you add or delete some requests
		performanceData = new PerformanceData(PAGE_BREAKS, MAX_THREAD_STEPS, concurrentUsers, maxParallelThreadsPerUser, plannedTestDuration, maxPlannedLoops, httpProtocolVersion, plannedStartupDelay, plannedRequestTimeout, samplingInterval, percentilePageSampling, percentileUrlSampling, percentileUrlSamplingAddOption);
		performanceData.setInfoText("OpenObligation_LT");
		performanceData.setExecutorsAnnotation(testRunAnnotation);
		if (commonNextProxyConfig != null)
		{
			performanceData.setProxyInfo(proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort);
			performanceData.addTestDescription("*** Warning: Load test executed via outbound proxy ***");
		}
		performanceData.setResultFileName(resultFile);
		performanceData.setDumpStream(System.out, "# ");
		performanceData.setMaxErrorSnapshots(maxErrorSnapshots);		// 0 = unlimited
		if (maxErrorSnapshotMemory >= 0)
			performanceData.setMaxErrorSnapshotsMemory(maxErrorSnapshotMemory * 1048576l);		// value in bytes
		
		if (sslECC)
			performanceData.addTestDescription("*** SSL/TLS ECC is enabled ***");
		
		if ((downlinkBandwidth != 0) || (uplinkBandwidth != 0))
		{
			String downlinkBandwidthStr = "unlimited";
			String uplinkBandwidthStr = "unlimited";
			
			if (downlinkBandwidth != 0)
				downlinkBandwidthStr = "" + downlinkBandwidth + " kbps";
			if (uplinkBandwidth != 0)
				uplinkBandwidthStr = "" + uplinkBandwidth + " kbps";
			
			performanceData.addTestDescription("*** Warning: Max. network bandwidth per user limited. downlink = " + downlinkBandwidthStr + ", uplink = " + uplinkBandwidthStr + " ***");
		}
		
		if ((percentileUrlSamplingAddOption != PerformanceDataTickExtension.EXT_TYPE_NOTYPE) && (percentileUrlSampling > 0))
			performanceData.addTestDescription("*** Warning: Option \"" + PerformanceDataTickExtension.extTypeToString(percentileUrlSamplingAddOption).toLowerCase() + "\" enabled for additional sampling rate per URL call ***");
		if (debugFailedLoops)
			performanceData.addTestDescription("*** Warning: Debug failed loops enabled ***");
		if (debugLoops)
			performanceData.addTestDescription("*** Warning: Debug loops enabled ***");
		if (debugHttp)
			performanceData.addTestDescription("*** Warning: Debug HTTP protocol headers enabled ***");
		if (debugContent)
			performanceData.addTestDescription("*** Warning: Debug HTTP content data enabled ***");
		if (debugCookies)
			performanceData.addTestDescription("*** Warning: Debug cookies enabled ***");
		if (debugKeepAlive)
			performanceData.addTestDescription("*** Warning: Debug keep-alive enabled ***");
		if (debugSsl)
			performanceData.addTestDescription("*** Warning: Debug SSL/TLS enabled ***");
		if (!sslProtocolVersion.equalsIgnoreCase("all"))
			performanceData.addTestDescription("*** Warning: SSL/TLS protocol version fixed to " + sslProtocolVersion.toUpperCase() + " ***");
		if (sslSessionCacheTimeout == 0)
			performanceData.addTestDescription("*** Warning: SSL/TLS session cache disabled ***");
		if (singleUserMode)
		{
			String singleUserModeWarning = "*** Warning: Single user mode enabled ***";
			System.out.println(singleUserModeWarning);
			performanceData.addTestDescription(singleUserModeWarning);
		}
		if (setUserAgentStr != null)
		{
			String overrideUserAgentWarning = "*** Warning: User agent set to \"" + setUserAgentStr + "\" ***";
			System.out.println(overrideUserAgentWarning);
			performanceData.addTestDescription(overrideUserAgentWarning);
		}
		
		
		// ready to start load test...
		initNull(concurrentUsers);
		performanceData.setUserContextTable(getUserContextTable());
		
		// ... but init first remote interface ...
		initRemote(args);
		
		// ... and init plug-in class loader ...
		try
		{
			if (getPluginClassLoader() == null)
				setPluginClassLoader(new LoadtestPluginClassLoader(getSymmetricEncryptContext(), getEncryptedClasspathList()));
		}
		catch (Throwable pluginClassLoaderThrowable)
		{
			System.out.println("*** ERROR: Unable to load encrypted files ***");
			pluginClassLoaderThrowable.printStackTrace();
			System.exit(-1);
		}
		
		// ... and check multihomed option ...
		initMultihomed(args);
		
		// ... and add dynaTrace session ID to load test result - if available ...
		initDynaTrace();
		
		
		// use test-specific DNS hosts file (optional) ?
		String dnsHostsFile = ParseArgs.getIgnoreCaseString(args, "-dnshosts");
		if (dnsHostsFile != null)
		{
			try
			{
				dnsCache = new DNSCache(getSymmetricEncryptContext(), dnsHostsFile);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS hosts file " + dnsHostsFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsHostsFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS translation table (optional) ?
		String dnsTranslationTableFile = ParseArgs.getIgnoreCaseString(args, "-dnstranslation");
		if (dnsTranslationTableFile != null)
		{
			try
			{
				DNSTranslationTable dnsTranslationTable = new DNSTranslationTable(getSymmetricEncryptContext(), new File(dnsTranslationTableFile));
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setDNSTranslationTable(dnsTranslationTable);
			}
			catch (IOException ie)
			{
				System.out.println("*** ERROR: unable to read DNS translation table file " + dnsTranslationTableFile + " ***");
				System.out.println("*** Hint: you have to ZIP " + dnsTranslationTableFile + " together with the compiled class of the load test program ***");
				ie.printStackTrace();
				System.exit(-1);
			}
		}
		
		// use test-specific DNS servers (optional) ?
		String dnsSrvStr = ParseArgs.getIgnoreCaseString(args, "-dnssrv");
		if (dnsSrvStr != null)
		{
			ArrayList<String> dnsSrvList = new ArrayList<String>();
			StringTokenizer dnsTok = new StringTokenizer(dnsSrvStr, ",;");
			while (dnsTok.hasMoreTokens())
				dnsSrvList.add(dnsTok.nextToken());
			if (dnsCache == null)
				dnsCache = new DNSCache(dnsSrvList);
			else
				dnsCache.setDnsServers(dnsSrvList);
		}
		
		// enable DNS TTL ?
		if (ParseArgs.hasOption(args, "-dnsenattl"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.enableTTL();
		}
		
		// set fixed DNS TTL ?
		Integer dnsFixTTL = ParseArgs.getInteger(args, "-dnsfixttl");
		{
			if (dnsFixTTL != null)
			{
				if (dnsCache == null)
					dnsCache = new DNSCache();
				dnsCache.setFixedTTL(dnsFixTTL.intValue());
			}
		}
		
		// enable DNS resolves per loop ?
		if (ParseArgs.hasOption(args, "-dnsperloop"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsPerLoop = true;
		}
		
		// enable DNS statistic ?   // note: use this option only if not any other, more specific DNS option is enabled.
		if (ParseArgs.hasOption(args, "-dnsstatistic"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
		}
		
		// debug DNS resolver ?
		if (ParseArgs.hasOption(args, "-dnsdebug"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setDebugToStdout(true);
		}
		
		// enable IPv6 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		// enable IPv6 and V4 
		if (ParseArgs.hasIgnoreCaseOption(args, "-enableIPv6v4"))
		{
			if (dnsCache == null)
				dnsCache = new DNSCache();
			dnsCache.setEnableIPv6v4(true);
			String networkInterfaceName = ParseArgs.getString(args, "-enableIPv6v4");
			if(null != networkInterfaceName && !networkInterfaceName.startsWith("-"))
				dnsCache.setNetworkInterfaceName(networkInterfaceName);
		}
		
		if (dnsCache != null)
		{
			// update performance data with DNS settings
			performanceData.addDNSCacheStatistic(dnsCache.getCacheStatistic());
			performanceData.addTestDescription("*** Warning: OS-independent DNS access enabled. " + dnsCache.getConfigInfoText() + " ***");
			if (dnsPerLoop)
				performanceData.addTestDescription("*** Warning: DNS option -dnsperloop enabled ***");
			
			// log DNS settings
			System.out.println("# OS-independent DNS access enabled. " + dnsCache.getConfigInfoText());
			if (dnsPerLoop)
				System.out.println("# DNS option -dnsperloop enabled");
		}
		
		// initialize file cache for large XML, SOAP and ASCII requests
		try
		{
			requestFileCache.readFile(getSymmetricEncryptContext(), REQUEST_FILE_CACHE_FILE_1);		// OpenObligation_LT_RequestContent0226.txt
			requestFileCache.readFile(getSymmetricEncryptContext(), REQUEST_FILE_CACHE_FILE_2);		// OpenObligation_LT_RequestContent0229.txt
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN DATA FILE FOR LARGE ASCII OR XML REQUEST ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
		// initialize input files
		try
		{
			P_Username_txt = new VarInputFileReader(getSymmetricEncryptContext(), "P_Username.txt", "@", ",", AbstractInputFileReader.EOF_REOPEN_FILE, prxCharEncoding);
			P_Username_txt.setTrimValues(true);
		}
		catch (IOException ie)
		{
			System.out.println("*** ERROR: UNABLE TO OPEN INPUT FILE ***");
			ie.printStackTrace();
			System.exit(-2);
		}
		
		// calculate sampling offset and virtual user startup offset for cluster jobs (time shift per cluster member)
		int samplingTimeshift = 0;	// value in seconds
		if (!ParseArgs.hasOption(args, "-nosdelayCluster"))
		{
			if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			{
				samplingTimeshift = Math.round(((float) samplingInterval / (float) getClusterTotalMemberCount()) * (float) getClusterMemberLocalId());
				System.out.println("# samplingTimeshift = " + samplingTimeshift + " seconds");
				
				long startupDelayOffset = (plannedStartupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
				System.out.println("# startupDelayTimeshift = " + startupDelayOffset + " milliseconds");
				System.out.println();
				if (startupDelayOffset > 0)
				{
					try { sleepRemoteInterruptable(startupDelayOffset); } catch (InterruptedException ie) {}
				}
			}
		}
		
		
		// update performance data
		// -----------------------
		testDurationStart = System.currentTimeMillis();
		performanceData.setStartDate();
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setSnapshotsTimeshift(samplingTimeshift);
		performanceData.setEndDate();
		
		// initialize global context for plug-ins  
		LoadtestPluginContext globalPluginContext = new LoadtestPluginContext(prxVersion, prxCharEncoding, new OpenObligation_LT());
		
		
		// --------------------------
		// *** start of load test ***
		// ---------------------------
		
		
		// special case for execution plans - start test with zero virtual users
		// ---------------------------------------------------------------------
		if (hasExecutionPlan())
		{
			if (concurrentUsers != 0)
			{
				System.out.println("*** Fatal Error: Load test with execution plan must start with zero number of virtual users - Load test program aborted ***");
				System.exit(1);
			}
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				OpenObligation_LT simulatedUser = new OpenObligation_LT(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, null);
				userContext.setLoadTestUserExecutionPlanPlaceholder();
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		
		// start virtual users as threads (normal case)
		// --------------------------------------------
		usersToBeIncreasedAtStartupOffset.set(concurrentUsers);
		for (int x = 0; x < concurrentUsers; x++)
		{
			if (cancelIncrementDecrementUser || cancelInitialIncrementUser)
			{
				usersToBeIncreasedAtStartupOffset.set(0);
				break;
			}
			
			// start load test thread
			// ----------------------
			Thread t = null;
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				OpenObligation_LT simulatedUser = new OpenObligation_LT(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				t = new Thread(simulatedUser);
				String threadName = "" + getUserContextTable().getUserContextList().size();
				threadName = THREAD_NAME.substring(0, 7 - threadName.length()) + threadName;
				t.setName(threadName);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(threadName + " ", System.out);		// dump log of constructor
					}
				}
				HttpLoadTestUserContext userContext = new HttpLoadTestUserContext(simulatedUser, t);
				getUserContextTable().getUserContextList().add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
			t.start();
			usersToBeIncreasedAtStartupOffset.decrementAndGet();
			System.out.println("# --- thread " + t.getName() + " created --- " + ZoneTime.dateToShortString() + " ---");
			
			while (isSuspend())
			{
				try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
				if (abortedByRemote() || abortedByEofInputFile())
					break;
				
				// check if max test duration reached during suspend
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
					break;
				
				// display and sample temporary performance data all "sampling interval" seconds - also during suspend
				if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
				{
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
				}
			}
			
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				break;
			
			// startup delay for next thread
			// -----------------------------
			try
			{
				if (!singleUserMode)   // create concurrent users
				{
					if (plannedStartupDelay <= 3000)
						sleepRemoteInterruptable(plannedStartupDelay);
					else
					{
						long startupDelayStartTime = System.currentTimeMillis();
						while (true)
						{
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							if ((System.currentTimeMillis() - startupDelayStartTime) >= plannedStartupDelay)
								break;
							
							Thread.currentThread().sleep(100);
							
							// display and sample temporary performance data all "sampling interval" seconds
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						while (isSuspend())
						{
							try { Thread.currentThread().sleep(100); } catch (InterruptedException ie) { break; }
							if (abortedByRemote() || abortedByEofInputFile())
								break;
							
							// check if max test duration reached during suspend
							if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
								break;
							
							// display and sample temporary performance data all "sampling interval" seconds - also during suspend
							if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
							{
								performanceData.addSnapshot(getCpuUsagePercent());
								performanceData.setEndDate();
							}
						}
						
					}
				}
				else
					t.join();   // single user mode
			}
			catch (InterruptedException ie) { break; }
			if (abortedByRemote() || abortedByEofInputFile())
				break;
			
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
		}
		usersToBeIncreasedAtStartupOffset.set(0);	// just in case that a thread is not started for any reason
		
		
		// wait for test-end in a loop
		// ---------------------------
		boolean allDone = false;
		while (!allDone)
		{
			// test aborted ?
			if (abortedByRemote() || abortedByEofInputFile())
			{
				nearRemoteEnd();
				String abort = "";
				if (abortedByRemote())
					abort = "*** test aborted by remote command ***";
				if (abortedByEofInputFile())
				{
					abort = "*** test aborted at eof of input file ***";
					performanceData.addTestDescription(abort);
				}
				synchronized (dumpLock)
				{
					addSSLCacheStatistic();
					performanceData.addSnapshot(getCpuUsagePercent());
					performanceData.setEndDate();
					
					if (!isRemote())
						performanceData.dump(false);
					if (resultFile != null)
						try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
					
					if(replayMode)
					{
						saveReplaySnapShots("ZTReplay.snapshot");
					}
					
					System.out.println();
					System.out.println(abort);
					System.out.println();
					System.out.flush();
					try { Thread.currentThread().sleep(10000); } catch (InterruptedException ie) {}
					System.exit(0);
				}
			}
			
			// display and sample temporary performance data all "sampling interval" seconds
			if (((System.currentTimeMillis() - performanceData.getLastSnapshotTime()) / 1000) >= samplingInterval)
			{
				performanceData.addSnapshot(getCpuUsagePercent());
				performanceData.setEndDate();
				if (!isRemote())
				{
					synchronized (dumpLock)
					{
						performanceData.dump(false);
					}
				}
			}
			
			// check if test has been done in case of decrement users to zero
			if ((decrementUser) && (plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				decrementUser = false;
			// check if test has been done
			if (!hasExecutionPlan())
				allDone = isTestDone();
			else
			{
				if ((plannedTestDuration > 0) && (((System.currentTimeMillis() - testDurationStart) / 1000) >= plannedTestDuration))
				{
					performanceData.addTestDescription("*** Warning: Load test aborted. Execution plan time limit exceeded after " + plannedTestDuration + " seconds ***");
					triggerAbort();
				}
			}
			
			// if not all is done: sleep one second
			if (!allDone)
				try { sleepRemoteInterruptable(1000); } catch (InterruptedException ie) { break; }
		} // end of wait loop
		
		
		// mark near end of test - only if a remote interface has been used
		nearRemoteEnd();
		
		
		
		// final test result - test completed
		// ----------------------------------
		performanceData.addSnapshot(getCpuUsagePercent());
		performanceData.setEndDate();
		if(replayMode)
		{
			saveReplaySnapShots("ZTReplay.snapshot");
		}
		
		// save test result
		performanceData.dump(true);
		if (resultFile != null)
			try { performanceData.writeObjectToFile(getSymmetricEncryptContext(), resultFile); } catch (IOException ie) { ie.printStackTrace(); }
		
		// all done
		System.out.flush();
		
		// wait for official end of test - only if a remote interface has been used
		waitRemoteEnd();
		
		System.out.println();
		System.out.println("Result File: " + resultFile);
		
		// now dead
		System.exit(0);
	}


	/**
	 * implement VaryingLoadInterface: support to increment the number of simulated users at runtime.
	 */
	public void setIncrementUser(long startTime)
	{
		incrementUserStartTime = startTime;
		incrementUserFlag = true;
	}

	public boolean isIncrementUser()
	{
		return incrementUserFlag;
	}

	public long getIncrementUserStartTime()
	{
		return incrementUserStartTime;
	}

	public void setIncrementUserStartTime(long startTime)
	{
		incrementUserStartTime = startTime;
	}

	public void clearIncrementUser()
	{
		incrementUserFlag = false;
	}

	public int incrementUsers(int numAddUsers, long startupDelay)
	{
		if (startupDelay < 0)
			startupDelay = plannedStartupDelay;
		return incrementUsersImplementation(numAddUsers, startupDelay, this);
	}

	static int incrementUsersImplementation(int numAddUsers, long startupDelay, HttpLoadTest httpLoadTest)
	{
		long startupDelayOffset = 0;
		if ((getClusterTotalMemberCount() > 1) && (getClusterMemberLocalId() > 0))
			startupDelayOffset = (startupDelay / ((long) getClusterTotalMemberCount())) * ((long) getClusterMemberLocalId());
		
		ArrayList<HttpLoadTestUserContext> addUserContextList = new ArrayList<HttpLoadTestUserContext>(numAddUsers);
		for (int x = 0; x < numAddUsers; x++)
		{
			if (abortedByRemote() || abortedByEofInputFile())
				return x;
			
			// initialize load test thread
			// ---------------------------
			try
			{
				getUserContextTable().getWriteLock().lock();
				
				OpenObligation_LT simulatedUser = new OpenObligation_LT(maxPlannedLoops, plannedRequestTimeout, getUserContextTable().getUserContextList().size());
				HttpLoadTestUserContext userContext = prepareIncrementUser(simulatedUser, System.currentTimeMillis() + startupDelayOffset + (x * startupDelay));
				addUserContextList.add(userContext);
				simulatedUser.setOwnLoadTestUserContext(userContext);
				if (debugLoops && (simulatedUser.getLog().size() > 0))
				{
					synchronized (dumpLock)
					{
						simulatedUser.dumpLog(userContext.getLoadTestThread().getName() + " ", System.out);		// dump log of constructor
					}
				}
			}
			finally
			{
				getUserContextTable().getWriteLock().unlock();
			}
		}
		
		// start load test threads by a thread
		// -----------------------------------
		HttpLoadTestIncrementUserThread incrementUserThread = new HttpLoadTestIncrementUserThread(httpLoadTest, addUserContextList);
		incrementUserThread.start();
		return numAddUsers;
	}


	/**
	 * Internal method used to load and apply next proxy settings from ZBAProxySettings.properties file.
	 * Settings are applied only if file exists and nextProxyIsActive is set to true in the file.
	 * Note that settings stored with the session, will be ineffective.
	 *
	 * @since V5.5-D
	 */
	private void applyNextProxySettingsFromFileIfExists()
	{
		
		String filename = "ZBAProxySettings.properties";
		BufferedReader bin = null;
		SymmetricEncryptContext decryptContext = getSymmetricEncryptContext();
		File file = new File(filename);
		
		if (file.exists())
		// open input file
		try
		{
			if (decryptContext == null)
			{
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")));
			}
			else
			{
				// create a reader stream that decrypts the data on the fly
				bin = new BufferedReader(new InputStreamReader(SymmetricEncrypt.getCipherInputStream(new FileInputStream(filename), decryptContext), Charset.forName("UTF-8")));
			}
			
			if (bin != null)
			{
				Properties nextProxyConfigProperties = new Properties();
				nextProxyConfigProperties.load(bin);
				NextProxyConfig nextProxyConfig = new NextProxyConfig();
				nextProxyConfig.setActive(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyIsActive")));
				proxyEnabled = nextProxyConfig.isActive();                             // if false: do not use a proxy server
				
				if (proxyEnabled)
				{
					nextProxyConfig.disableHttpProxyCache(Boolean.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpCacheDisabled")));
					proxyCacheDisabled = nextProxyConfig.isDisabledHttpProxyCache();
					nextProxyConfig.setHttpHost(nextProxyConfigProperties.getProperty("nextProxyHttpHost"));
					proxyHttpHost = nextProxyConfig.getHttpHost();
					nextProxyConfig.setHttpPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpPort")));
					proxyHttpPort = nextProxyConfig.getHttpPort();
					nextProxyConfig.setHttpsHost(nextProxyConfigProperties.getProperty("nextProxyHttpsHost"));
					proxyHttpsHost = nextProxyConfig.getHttpsHost();
					nextProxyConfig.setHttpsPort(Integer.valueOf(nextProxyConfigProperties.getProperty("nextProxyHttpsPort")));
					proxyHttpsPort = nextProxyConfig.getHttpsPort();
					nextProxyConfig.setAuthUsername(nextProxyConfigProperties.getProperty("nextProxyAuthUsername"));
					nextProxyConfig.setAuthPassword(nextProxyConfigProperties.getProperty("nextProxyAuthPassword"));
					nextProxyConfig.setNoNextProxy(nextProxyConfigProperties.getProperty("noNextProxy"));
					noProxyFor = nextProxyConfig.getNoNextProxy();
					
					String proxyAuth = "";
					
					if (nextProxyConfig.getAuthUsername() != null)
					{
						proxyAuth = nextProxyConfig.getAuthUsername() + ":";
						if (nextProxyConfig.getAuthPassword() != null)
							proxyAuth = proxyAuth + nextProxyConfig.getAuthPassword();
					}
					
					String  proxyAuthorization = null;
					
					if (proxyAuth.length() > 1)
						proxyAuthorization = Base64Encoder.encode(proxyAuth);		// Base 64 encoded - used for basic authentication only
					
					commonNextProxyConfig = new NextProxyConfig(proxyEnabled, proxyCacheDisabled, proxyHttpHost, proxyHttpPort, proxyHttpsHost, proxyHttpsPort, proxyAuthorization, noProxyFor);
					
					log("*** Warning: Applying proxy configuration from file " + filename + " ***");
				}
				
			}
		}
		catch (Throwable tr)
		{
			log("*** Unable to load proxy configuration from properties file " + filename + " ***");
			tr.printStackTrace();
		}
		finally
		{
			if (bin != null)
			{
				try { bin.close(); } catch (Exception e) {}
			}
		}
		
	}
		
	// definition for external files used to support large XML, SOAP and ASCII requests
	// --------------------------------------------------------------------------------
	public static final String REQUEST_FILE_CACHE_FILE_1 = "OpenObligation_LT_RequestContent0226.txt";		// must be zipped together with the compiled class of this load test program
	public static final String REQUEST_FILE_CACHE_FILE_2 = "OpenObligation_LT_RequestContent0229.txt";		// must be zipped together with the compiled class of this load test program
	

}	// end of class

