# 🧪 Coding Kata：Log Aggregator v2

給你一題偏「設計 + 可演進」的 Kata，會貼近你現在在做的東西（分層 + stream + 可維護性）。

## 🎯 題目背景

你正在做一個系統，需要分析應用程式的 log，並輸出統計結果。

每筆 log 長這樣：

```java
class LogEntry {
    private LocalDateTime timestamp;
    private LogLevel level; // INFO, WARN, ERROR
    private String service;
    private String message;
}
```

---

## 🧩 任務需求（分階段）

## Phase 1：基本統計

輸入：`List<LogEntry> logs`

輸出：

```java
Map<LogLevel, Long>
```

要求：

* 統計每種 LogLevel 的數量
* 依照數量「由大到小排序」

👉 重點：

* `groupingBy`
* `counting`
* `sorted + comparator`

---

## Phase 2：進階分組

輸出：

```java
Map<String, Map<LogLevel, Long>>
```

結構：

```
serviceA -> { ERROR: 10, WARN: 5 }
serviceB -> { INFO: 20 }
```

要求：

* 先依 `service` 分組
* 每個 service 再依 `LogLevel` 統計

👉 重點：

* 巢狀 groupingBy

---

## Phase 3：時間區間過濾

新增方法：

```java
List<LogEntry> filterByTimeRange(
    List<LogEntry> logs,
    LocalDateTime start,
    LocalDateTime end
)
```

要求：

* 包含 start，不包含 end `[start, end)`
* 回傳符合條件的 logs

👉 重點：

* predicate clean 寫法（不要寫醜 if）

---

## Phase 4：Top N Error Service（🔥）

輸出：

```java
List<String> topNErrorServices(List<LogEntry> logs, int n)
```

要求：

* 找出 ERROR 最多的前 N 個 service
* 如果數量一樣，用 service name 排序

👉 重點：

* sorting tie-breaker
* stream pipeline 設計

---

## Phase 5：可擴充設計（重點）

現在需求變了：

之後可能會新增：

* 依 user 分析
* 依 region 分析
* 自訂 filter（例如只看某些 service）

👉 你要做：

設計一個：

```java
class LogAnalyzer {
    // 可插 filter
    // 可插 aggregation
}
```

建議方向（不用完全照）：

```java
interface LogFilter {
    boolean test(LogEntry log);
}

interface Aggregator<T> {
    T aggregate(List<LogEntry> logs);
}
```

👉 重點：

* 開放擴充（OCP）
* 不要寫死邏輯在 method 裡

---

## 🧠 加分題（選做）

1. 支援 parallel stream（thread-safe 思考）
2. 做成 fluent API：

```java
analyzer
    .filter(...)
    .groupBy(...)
    .count()
```

3. 測試：

   * edge case（空 list / null）
   * 大量資料

---

## 💣 刻意練習重點

這題不是在考「會不會寫 stream」，而是：

* pipeline 可讀性
* comparator 寫法乾不乾淨
* grouping 結構設計
* 把邏輯拆乾淨（不是全寫在一行）
* 未來需求進來會不會炸

---

如果你明天寫完，可以丟 code 給我，我會幫你 review：

* 設計層級（Core / Data / API 有沒有混）
* stream 使用是不是過度或不夠
* 可讀性 vs 彈性 trade-off

這題寫得好，基本上你在後端資料處理這塊會直接升一個等級。
