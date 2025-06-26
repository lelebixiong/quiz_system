🎓 Quiz System

一个简洁而强大的在线测验系统，支持题目展示、用户作答、自动评分与结果反馈，适用于教育、培训或自测平台。

🚀 项目功能

多种题型支持（单选题、多选题、判断题等）

题库管理与动态加载

用户作答界面（命令行 / Web 前端）

自动评分系统

成绩统计与反馈展示

支持多用户登录（可选）

结果导出（JSON / CSV 格式）

🛠️ 技术栈
<请按实际填写你的项目技术栈，如：>

Backend: Python (Flask) / Node.js / Java

Frontend: HTML + CSS + JavaScript / React / Vue (可选)

Database: SQLite / PostgreSQL / Firebase

Others: Bootstrap / Tailwind CSS / Chart.js

📁 项目结构

csharp
复制
编辑
quiz-system/
├── data/                  # 存储题库和成绩的文件

│   └── questions.json

├── static/                # 前端静态资源

│   └── ...

├── templates/             # HTML 模板（用于 Web 项目）

│   └── ...

├── app.py                 # 主程序文件（或 index.js / main.java）

├── utils/                 # 工具函数模块

├── README.md              # 项目说明文件

└── requirements.txt       # 依赖列表

🧪 使用方法

安装依赖
bash
复制
编辑
pip install -r requirements.txt   # Python 项目
# 或者
npm install                       # Node 项目
启动系统
bash
复制
编辑
python app.py
# 或
npm start


使用流程
进入测验页面，选择题目类型

浏览并作答

提交答案

查看得分与正确答案解析

📝 自定义题库

题库格式示例如下（data/questions.json）：

json
复制
编辑
[
  {
    "id": 1,
    "question": "Python 中用于定义函数的关键字是？",
    "options": ["def", "func", "define", "function"],
    "answer": [0],
    "type": "single"
  }
]

👥 作者与贡献

作者：陈熙元

欢迎 PR 与建议，共同完善项目！
