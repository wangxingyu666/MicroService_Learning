const express = require("express");
const { OpenAI } = require("openai");
const bodyParser = require("body-parser");

const app = express();
const port = 8081;

const openai = new OpenAI({
  apiKey: "sk-f57f5e97e00b4b72acf825892b758803",
  baseURL: "https://dashscope.aliyuncs.com/compatible-mode/v1",
});

app.use(bodyParser.json());

app.get("/ask", async (req, res) => {
  const { name } = req.query;

  if (!name) {
    return res.status(400).json({ error: "Missing query parameter: name" });
  }

  try {
    const completion = await openai.chat.completions.create({
      model: "qwen-plus",
      messages: [
        {
          role: "system",
          content:
            "You are a helpful assistant. Please answer in Chinese only, without any English explanation.",
        },
        { role: "user", content: `What is the answer for ${name}?` },
      ],
    });

    const answer = completion.choices[0].message.content;

    res.json({ answer: answer });
  } catch (error) {
    console.error("Error during AI call:", error);

    res
      .status(500)
      .json({ error: "AI model call failed", details: error.message });
  }
});

app.listen(port, () => {
  console.log(`AI Service listening at http://127.0.0.1:${port}`);
});
