import * as routes from '../routes/route';

export const convertor = async () => {
  const resEur = await routes.EURToRUB();
  const resGbp = await routes.GBPToRUB();
  return {
    conversionMultipleEUR: resEur.data.conversionMultiple,
    conversionMultipleGBP: resGbp.data.conversionMultiple,
  };
};
