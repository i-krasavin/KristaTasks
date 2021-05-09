FROM node:14

WORKDIR /home/node/app

COPY . .

RUN npm install

RUN npm run build


FROM node:14
# Create app directory
WORKDIR /home/node/app
COPY package*.json ./
RUN npm ci --only=production
# Bundle app source
COPY --from=0 /home/node/app/dist ./dist

EXPOSE 8080
CMD npm start