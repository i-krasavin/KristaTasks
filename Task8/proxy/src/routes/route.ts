import axios from 'axios';

export const GBPToRUB = async () => await axios('host.docker.internal:8000/currency-exchange/from/GBP/to/RUB');
export const EURToRUB = async () => await axios('host.docker.internal:8000/currency-exchange/from/EUR/to/RUB');
