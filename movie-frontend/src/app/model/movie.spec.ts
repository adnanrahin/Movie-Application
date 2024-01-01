import { Movie } from './movie';

describe('Movie', () => {
  it('should create an instance', () => {
    // @ts-ignore
    expect(new Movie()).toBeTruthy();
  });
});
