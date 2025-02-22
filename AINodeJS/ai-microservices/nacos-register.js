const nacos = require("nacos-sdk").Nacos;

// 配置 Nacos 客户端
const client = new nacos.NacosNamingClient({
  serverList: "127.0.0.1:8848", // Nacos 服务器地址
  namespace: "public", // 命名空间，默认 'public'
  clientIP: "127.0.0.1",
});

// 注册服务到 Nacos
async function registerService(serviceName, port) {
  try {
    await client.registerInstance(serviceName, {
      ip: "127.0.0.1",
      port: port,
      serviceName: serviceName,
    });
    console.log(`${serviceName} 注册到 Nacos 成功！`);
  } catch (error) {
    console.error(`${serviceName} 注册失败: `, error);
  }
}

// 导出注册函数
module.exports = registerService;
