
# Temperature Processing

Uma API REST para processamento e análise de dados de sensores de temperatura implementada com Spring Boot.

## Descrição

Temperature Processing é uma aplicação Spring Boot que fornece endpoints REST para receber e processar leituras de temperatura enviadas por sensores remotos. A aplicação aceita valores de temperatura em formato texto simples, registra os dados junto com o timestamp de recebimento e disponibiliza recursos para processamento posterior.

## Requisitos

- Java 21
- Gradle 8.x ou superior

## Tecnologias Utilizadas

- Spring Boot 3.4.4
- Hypersistence TSID (Time-Sorted ID generator)
- Lombok
- Apache Commons Lang

## Instalação

```bash
# Clone o repositório
git clone https://github.com/frafaelptu/temperature-processing.git

# Entre no diretório
cd temperature-processing

# Compile e empacote o projeto com Gradle
./gradlew build
```

## Execução

```bash
# Execute com Gradle
./gradlew bootRun

# Ou execute o JAR gerado
java -jar build/libs/temperature-processing-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em http://localhost:8081

## API Endpoints

### Enviar Leitura de Temperatura

```http
POST /api/sensors/{sensorId}/temperatures/data
```

#### Parâmetros da URL:
- sensorId: ID do sensor no formato TSID (Time-Sorted ID)

#### Cabeçalhos da Requisição:
- Content-Type: text/plain

#### Corpo da Requisição:
Valor numérico da temperatura (em formato texto)

#### Exemplo de Uso com cURL:
```bash
curl -X POST \
  http://localhost:8081/api/sensors/01H6PCZRDJ2ZYXN8N6PRX4ZHTY/temperatures/data \
  -H 'Content-Type: text/plain' \
  -d '23.5'
```

### Resposta

Em caso de sucesso, a operação retornará um status HTTP 200 (OK) sem corpo na resposta.

Em caso de erro:
- Status 400 (Bad Request): Se o valor da temperatura não for válido ou estiver vazio
- Status 404 (Not Found): Se o sensor ID não for encontrado

## Modelo de Dados

```java
public class TemperatureLogOutput {
    private UUID id;           // Identificador único do registro
    private String sensorId;   // ID do sensor que enviou a leitura
    private OffsetDateTime registeredAt;  // Data e hora do registro
    private Double value;      // Valor da temperatura
}
```

## Configuração

O arquivo application.yml contém as configurações da aplicação:

```yaml
server.port: 8081

spring:
  application.name: temperature-processing
```

## Estrutura do Projeto

```
temperature-processing/
├── gradle/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── frafael/
│   │   │           └── sensors/
│   │   │               └── temperature/
│   │   │                   └── processing/
│   │   │                       ├── api/
│   │   │                       │   ├── config/
│   │   │                       │   │   └── web/
│   │   │                       │   │       ├── StringToTSIDWebConverter.java
│   │   │                       │   │       └── WebConfig.java
│   │   │                       │   ├── controller/
│   │   │                       │   │   └── TemperatureProcessingController.java
│   │   │                       │   └── model/
│   │   │                       │       └── TemperatureLogOutput.java
│   │   │                       └── TemperatureProcessingApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/
│               └── frafael/
│                   └── sensors/
│                       └── temperature/
│                           └── processing/
│                               └── TemperatureProcessingApplicationTests.java
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## Desenvolvimento

### Pré-requisitos para Desenvolvimento

- JDK 21
- IDE compatível com Spring Boot (IntelliJ IDEA, Eclipse, VS Code)
- Gradle

### Executando Testes

```bash
./gradlew test
```

## Funcionalidades Futuras

- Endpoints para consulta de histórico de temperaturas
- Cálculo de médias e estatísticas de temperatura
- Alertas para valores fora dos limites estabelecidos
- Dashboard para visualização dos dados de temperatura
- Suporte para diferentes tipos de sensores

## Contribuição

1. Faça um fork do projeto  
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)  
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)  
4. Push para a branch (`git push origin feature/nova-feature`)  
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.

## Contato

- Desenvolvedor: Rafael F.  
- GitHub: [frafaelptu](https://github.com/frafaelptu)

