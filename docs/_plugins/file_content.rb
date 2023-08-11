module Jekyll
  module FileContentFilter
    def file_content(input, start_line = nil, end_line = nil, spaces = 0)
      filepath = File.join(Dir.pwd, input)
      content = File.read(filepath)

      lines = content.lines.to_a
      start_line = start_line ? start_line.to_i - 1 : 0
      end_line = end_line ? end_line.to_i - 1 : lines.size - 1

      selected_lines = lines[start_line..end_line]
      unindented_lines = selected_lines.map { |line| line[spaces..-1] }
    end
  end
end

Liquid::Template.register_filter(Jekyll::FileContentFilter)
