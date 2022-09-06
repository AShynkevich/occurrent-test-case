## Step 1
Start your mongo db instance

OR

run 

```shell
docker-compose -f docker-compose.yml up -d
```

## Step 2
Start application

```java
    public static void main(String[] args) {
        SpringApplication.run(BigDecimalCase.class);
    }
```

## Step 3
Post construct in the **NameApplicationService** object performs the code

```java
    @PostConstruct
    void init() {
        LocalDateTime now = LocalDateTime.now();
        UUID id = UUID.randomUUID();

        defineName(id, now, "Alex", new BigDecimal("1234567890123456.62"));
    }
```

## Step 4 
See db **test.events**. Data has spoiled number