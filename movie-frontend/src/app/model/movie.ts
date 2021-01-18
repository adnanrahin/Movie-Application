export class Movie {
  filmId: number;
  title: string;
  description: string;
  releaseYear: string;
  languageId: number;
  originLanguageId: number;
  rentalDuration: number;
  rentalRate: number;
  length: number;
  replacementCost: number;
  rating: string;
  specialFeatures: string;
  lastUpdate: Date;


  // tslint:disable-next-line:max-line-length
  constructor(filmId: number, title: string, description: string, releaseYear: string,
              languageId: number, originLanguageId: number, rentalDuration: number,
              rentalRate: number, length: number, replacementCost: number, rating: string,
              specialFeatures: string, lastUpdate: Date) {
    this.filmId = filmId;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.languageId = languageId;
    this.originLanguageId = originLanguageId;
    this.rentalDuration = rentalDuration;
    this.rentalRate = rentalRate;
    this.length = length;
    this.replacementCost = replacementCost;
    this.rating = rating;
    this.specialFeatures = specialFeatures;
    this.lastUpdate = lastUpdate;
  }

  getLastUpdateDate(): Date {
    return new Date(this.lastUpdate);
  }
}
