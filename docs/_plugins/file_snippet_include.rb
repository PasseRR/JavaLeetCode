
module Jekyll
  class FileSnippetIncludeTag < Liquid::Tag
    def initialize(tag_name, text, tokens)
      super
      @filename, @start_line, @end_line = text.split("!")
    end
 
    def render(context)
      filepath = File.join(context.registers[:site].config["source"], @filename)
      content = File.read(filepath)    
      lines = content.lines.to_a
      start_line = @start_line ? @start_line.to_i - 1 : 0
      end_line = @end_line ? @end_line.to_i - 1 : lines.size - 1    
      selected_lines = lines[start_line..end_line]
    end
    
  end

end

Liquid::Template.register_tag('file_snippet', Jekyll::FileSnippetIncludeTag)
