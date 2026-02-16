
# Coding Kata：Log Aggregator（日誌彙整器）

## 題目背景

系統會輸出 application log，每行格式如下：

```
2026-02-16 10:15:32 INFO User login success
2026-02-16 10:15:35 ERROR Database timeout
2026-02-16 10:16:02 WARN Memory usage high
2026-02-16 10:16:10 ERROR Connection refused
```

請寫一個程式，輸入多行 log，輸出統計結果。

---

# Level 1（基本）

輸入：

* List<String> logs

輸出：

* 各等級出現次數

```
INFO 1
WARN 1
ERROR 2
```

---

# 規則

log 格式固定：

```
yyyy-MM-dd HH:mm:ss LEVEL message
```

LEVEL 只有：

```
INFO
WARN
ERROR
```

---

# 建議實作

Java 方向：

```java
class LogEntry {
    LocalDateTime time;
    String level;
    String message;
}
```

拆成三步：

1. parse log
2. aggregate
3. print result

---

# Level 2（稍微進階）

新增需求：

輸出：

* 每個 level 的第一筆時間
* 最後一筆時間

結果：

```
ERROR count=2 first=10:15:35 last=10:16:10
WARN  count=1 first=10:16:02 last=10:16:02
INFO  count=1 first=10:15:32 last=10:15:32
```

---

# Level 3（設計能力）

需求變更：

log 來源可能是：

* file
* DB
* REST API

要求：

```
LogSource interface
```

```java
interface LogSource {
    List<String> fetchLogs();
}
```

讓 aggregator 不依賴來源。

---

# Level 4（實務味）

新增需求：

只統計最近 N 分鐘

```java
aggregate(logs, Duration.ofMinutes(5))
```

要考慮：

* clock injection（不要直接用 now()）

---

# Level 5（架構味）

新增：

支援新的 level：

```
DEBUG
FATAL
```

要求：

* 不改 aggregator code

提示：

* Enum strategy
* Map<String, Stat>

---

# Kata 的練習重點

這題可以練：

1. parsing
2. stream / collection
3. small object design
4. interface abstraction
5. 可測試性

而且可以一路重構。

---

# 如果你想要更硬一點的版本（我很推薦）

我可以給你一個：

**Spring Batch mini kata**
或
**簡化版排程系統 kata**

這兩個會非常貼近你現在在做的東西，而且會讓很多觀念直接打通。

你想練哪種？

1. 演算法偏多
2. 物件設計 / 重構型
3. Batch / 系統設計型（最接近你現在的工作）
