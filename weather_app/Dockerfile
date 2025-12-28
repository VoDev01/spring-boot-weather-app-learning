# syntax=docker/dockerfile:1

FROM node:25.2-alpine

COPY ./package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "run", "dev"]