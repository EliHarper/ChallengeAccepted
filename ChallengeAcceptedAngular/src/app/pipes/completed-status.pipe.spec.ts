import { CompletedStatusPipe } from './completed-status.pipe';

describe('CompletedStatusPipe', () => {
  it('create an instance', () => {
    const pipe = new CompletedStatusPipe();
    expect(pipe).toBeTruthy();
  });
});
