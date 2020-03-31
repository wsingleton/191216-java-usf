
@RestController
@RequestMapping("/message")
public class MessageController{

    @Autowired
    QueueService service;

    @PostMapping
    publicString sendMessage(@RequestBody String message){
        return service.sendMesasage(message)
    }
}