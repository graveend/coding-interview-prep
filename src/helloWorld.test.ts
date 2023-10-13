const helloWorld = (name: string = "World"): string => {
  return `Hello, ${name}!`;
};

describe("helloWorld", () => {
  test("returns generic message", () => {
    expect(helloWorld()).toBe("Hello, World!");
  });

  test("returns personalised message", () => {
    expect(helloWorld("Molly")).toBe("Hello, Molly!");
  });
})