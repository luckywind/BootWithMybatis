package com.mybatis3.exception.handler;

import com.mybatis3.util.Result;
import com.mybatis3.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的；
 * 结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的；
 * 结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * 起兜底作用，如果是已知异常，可以把已知异常作为@ExceptionHandler的参数
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Result handleException(Exception e){
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR),e.getMessage());
    }



    /**
     * 处理所有接口数据验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    /**
     * 使用@InitBinder注册Date类型参数转换器：
     *
     * 该注解的主要作用是绑定一些自定义的参数。一般情况下我们使用的参数通过@RequestParam，
     * @RequestBody或者@ModelAttribute等注解就可以进行绑定了，但对于一些特殊类型参数，
     * 比如Date，它们的绑定Spring是没有提供直接的支持的，我们只能为其声明一个转换器，
     * 将request中字符串类型的参数通过转换器转换为Date类型的参数，从而供给@RequestMapping标注的方法使用
     *
     * 例如：
     * @RequestMapping(value = "/detail", method = RequestMethod.GET)
     *   public ModelAndView detail(@RequestParam("id") long id, Date date) {
     *   请求http://localhost:8080/user/detail?id=1&date=2018-10-2
     */
    @InitBinder
    public void globalInitBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
