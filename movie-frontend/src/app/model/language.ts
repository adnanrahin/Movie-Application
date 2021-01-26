export class Language {

  // tslint:disable-next-line:variable-name
  private _languageId: number;
  // tslint:disable-next-line:variable-name
  private _name: string;
  // tslint:disable-next-line:variable-name
  private _lastUpdate: Date;

  constructor(languageId: number, name: string, lastUpdate: Date) {
    this._languageId = languageId;
    this._name = name;
    this._lastUpdate = lastUpdate;
  }

  get languageId(): number {
    return this._languageId;
  }

  set languageId(value: number) {
    this._languageId = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get lastUpdate(): Date {
    return this._lastUpdate;
  }

  set lastUpdate(value: Date) {
    this._lastUpdate = value;
  }
}
