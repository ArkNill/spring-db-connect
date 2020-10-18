public class ElasticsearchTest {
	ElasticSoundService elasticSoundService;

	@Autowired
	@Qualifier("elasticSoundRepository")
	ElasticSoundRepository elasticSoundRepository;

	@Before
	public void setup() {
		elasticSoundService = new ElasticSoundService(elasticSoundRepository);
	}

	@Test
	public void whenValidParameter_thenSuccessFind() {
	    List<ElasticSound> list = elasticSoundService.findAll();
	    assertNotNull(list);
	}

	@Test
	public void whenValidParameter_thenSuccessSave() {
		Exception ex = null;

	    try {
	    	elasticSoundService.save(ElasticSound.builder().category("lecture").title("음성 데이터 제목").company("EBS").content("음성 데이터 내용이 옴~~~").build());
	    } catch (Exception exception) {
	    	ex = exception;
	    }

	    assertTrue(null == ex);
	}

	@Test
	public void whenValidParameter_thenSuccessFindByUser() {
	    Exception ex = null;

	    try {
	    	ElasticSound ElasticSound = elasticSoundService.findByCategory("lecture");
	    	assertThat(ElasticSound, is(IsNull.notNullValue()));
	    } catch (Exception exception) {
	    	ex = exception;
	    }

	    assertTrue(null == ex);
	}
}
