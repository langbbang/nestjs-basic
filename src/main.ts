import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

async function bootstrap() {
  /**
   * root module은  AppModule이며, 해당 AppModule은 애플리케이션 전체에 모듈을 통합한 모듈이다.
   * NestFactory는 AppModule을 통해 애플리케이션 전체에 모듈을 조립하고 필요한 클래스를 생성해서 서버를 실행한다.
   */
  const app = await NestFactory.create(AppModule);
  await app.listen(3000);
}
bootstrap();
