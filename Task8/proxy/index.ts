import express from 'express';
import { convertor } from './src/businessLogic/converter';
import cors from 'cors';

const app = express();
const PORT = 8080;
app.use(cors());

app.post('/', express.json(), async (req, res, next) => {
  try {
    console.log('Info: POST request');
    const { salary } = req.body;
    console.log(`Salary: ${salary}`);
    console.log('Trying to get currency');
    const { conversionMultipleEUR, conversionMultipleGBP } = await convertor();
    console.log(`conversionMultipleEUR: ${conversionMultipleEUR}`);
    console.log(`conversionMultipleGBP: ${conversionMultipleGBP}`);
    const convertedResult = {
      eur: salary * conversionMultipleEUR,
      gbp: salary * conversionMultipleGBP
    };
    res.send({ data: convertedResult });
  } catch (err) {
    console.log('Unexpected error...');
    console.log(err);
    res.send({ data: { eur: 0, gbp: 0 } });
  }
});

app.listen(PORT, () => {
  console.log(`⚡️[server]: Server is running at https://localhost:${PORT}`);
});
