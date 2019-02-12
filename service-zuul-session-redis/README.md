# service-zuul-session-redis

# *[1、springboot+zuul实现session共享]
# *[2、zuul实现动态配置]

<h2 id="session">+zuul实现session共享 zuul动态路由</h2>

# 1、说明
springsession+redis+springboot使用上一个repository就可以了。我们这里关注zuul的配置。
# 2、zuul的默认配置，引入zuul的依赖,同时引入springsession和redis的依赖

防止springcloud版本冲突，我们可以指定版本，通过指定管理依赖

# 3 实现刷新接口，同时通过事件发送刷新方法

通过调用:http://localhost:1100/getAllRoutes/  接口,添加配置信息我们就可以看到相关配置


```

    /**
     * 加载所有可配置的路由规则
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/routes",method = RequestMethod.GET)

    /**
     * 添加一条路由规则
     * @param serviceId
     * @param path
     * @param url
     * @param headers
     * @return
     */
     @RequestMapping(value = "/routes/{serviceId}",method = RequestMethod.POST)
     public String addRoutes(@PathVariable String serviceId,
                            @RequestParam String path,
                            @RequestParam String url,
                            @RequestParam(required = false) String headers);

    /**
     * 删除指定的路由
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/routes/{serviceId}",method = RequestMethod.DELETE)
    public String delteRoutes(@PathVariable String serviceId)
    
    /**
     * 删除指定的路由
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/routes/{serviceId}",method = RequestMethod.PUT)
    public String updateRoutes(@PathVariable String serviceId,
                               @RequestParam String path,
                               @RequestParam String url,
                               @RequestParam String headers)

    /**
     * 发送事件，刷新路由规则
     */
    private void refreshRoute()
}
```
