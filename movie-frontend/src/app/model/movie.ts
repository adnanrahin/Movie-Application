import {Language} from './language';
import {Actor} from './actor';

export class Movie {
  filmId: number;
  title: string;
  description: string;
  releaseYear: string;
  language: Language;
  originLanguageId: number;
  rentalDuration: number;
  rentalRate: number;
  length: number;
  replacementCost: number;
  rating: Rating;
  specialFeatures: string;
  lastUpdate: Date;
  actors: Actor[];


  // tslint:disable-next-line:max-line-length
  constructor(filmId: number, title: string, description: string, releaseYear: string,
              language: Language, originLanguageId: number, rentalDuration: number,
              rentalRate: number, length: number, replacementCost: number,
              specialFeatures: string, lastUpdate: Date, rating: Rating, actors: Actor[]) {
    this.filmId = filmId;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.language = language;
    this.originLanguageId = originLanguageId;
    this.rentalDuration = rentalDuration;
    this.rentalRate = rentalRate;
    this.length = length;
    this.replacementCost = replacementCost;
    this.rating = rating;
    this.specialFeatures = specialFeatures;
    this.lastUpdate = lastUpdate;
    this.actors = actors;
  }

  getLastUpdateDate(): Date {
    return new Date(this.lastUpdate);
  }
}
// @ts-ignore
export enum Rating {
  G = 'G', PG = 'PG', R = 'R'
}
